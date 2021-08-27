import java.util.Scanner;

public class ProgrammingAssignment3 {

    public static int digitsEqual(int input){
       boolean equalDigit = false;

       do{
           int firstDigit = input%10; 
           int secondDigit = (input%100 - firstDigit) / 10; 
           if(firstDigit == secondDigit) {
               equalDigit = true;
           }else {
               input--;
           }
       }while(!equalDigit);

        return input;
    }

    public static void main(String[] args) {

        Scanner scnr = new Scanner(System.in);
        int num = scnr.nextInt();
        if (num < 11 || num > 100) {
            System.out.print("Input must be 11-100");
        } else {
                for(int i = num; i >= digitsEqual(num); i--){
                    System.out.print(i + " ");
                }
            }
        System.out.println();
    }
}