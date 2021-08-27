// By Hitam Yadav

package Anagrams;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.IOException;

public class Anagrams {
    final Integer[] primes;
    Map<Character, Integer> letterTable;
    Map<Long, ArrayList<String>> anagramTable;

    public Anagrams() {
        this.primes = new Integer[] { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101 };
        this.letterTable = new HashMap<Character, Integer>();
        this.anagramTable = new HashMap<Long, ArrayList<String>>();
        buildLetterTable();
    }

    //To build the hast table lettertable
    private void buildLetterTable() {
        String letters = "abcdefghijklmnopqrstuvwxyz";

        int i = 0;
        if (i < letters.length()) do {
            this.letterTable.put(letters.charAt(i), primes[i]);
            ++i;
        } while (i < letters.length());
    }

//Computing the hash code of the string, add to the anagramTable hash table
    private void addWord(String s) {
        if (s == null) {
            throw new NullPointerException("Must be a String");
        }

        if (!(s instanceof String)) {
            throw new NullPointerException("Must be a String");
        }

        long hash = myHashCode(s);

        ArrayList<String> list = this.anagramTable.get(hash);

        if (list == null) {
            list = new ArrayList<String>();
            list.add(s);
        } else if (list.contains(s)) {
            System.out.println("String \"" + s + "\" already in ArrayList");

            return;

        } else {
            list.add(s);
        }

        this.anagramTable.put(hash, list);
    }


//Computing hash code
    private Long myHashCode(String s) {
        if (s == null) {
            throw new NullPointerException("Must be a String");
        }

        if (!(s instanceof String)) {
            throw new NullPointerException("Must be a String");
        }

        Long hash = 1L;

        int i = 0;
        while (i < s.length()) {
            hash *= Long.valueOf(this.letterTable.get(s.charAt(i)));
            ++i;
        }

        return hash;
    }

// retrieves the name of the file and builds anagramTable
    public void processFile(String s) throws IOException {
        FileInputStream stream = new FileInputStream(s);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(stream));
        String test;

        if ((test = bufferedReader.readLine()) != null) {
            do {
                this.addWord(test);
            } while ((test = bufferedReader.readLine()) != null);
        }
        bufferedReader.close();
    }

//returning the entries from the anagramTable with the largest # of anagrams.
    private ArrayList<Map.Entry<Long, ArrayList<String>>> getMaxEntries() {
        ArrayList<Map.Entry<Long, ArrayList<String>>> list;
        list = new ArrayList<Map.Entry<Long, ArrayList<String>>>();

        int length = 0;

        for (Iterator<Map.Entry<Long, ArrayList<String>>> iterator = anagramTable.entrySet().iterator(); iterator.hasNext(); ) {
            Map.Entry<Long, ArrayList<String>> entry = iterator.next();
            if (entry.getValue().size() == length) {
                list.add(entry);
            } else if (entry.getValue().size() > length) {
                list.clear();
                length = entry.getValue().size();
                list.add(entry);
            }
        }
        return list;
    }

//main method from assignment instructions to run the program
    public static void main(String[] args) {
        Anagrams a = new Anagrams();
        final long startTime = System.nanoTime();
        try {
            a.processFile("words_alpha.txt");
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        ArrayList<Map.Entry<Long, ArrayList<String>>> maxEntries = a.getMaxEntries();
        final long estimatedTime = System.nanoTime() - startTime;
        final double seconds = ((double) estimatedTime / 1000000000);
        System.out.println("Elapsed Time: " + seconds);
        System.out.println("Key of max anagrams: " + maxEntries.get(0).getKey());
        System.out.println("List of max anagrams: " + maxEntries.get(0).getValue());
        System.out.println("Length of list of max anagrams: " + maxEntries.get(0).getValue().size());
    }
}