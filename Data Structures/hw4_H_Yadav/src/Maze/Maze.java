//By Hitam Yadav
package Maze;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Class that solves maze problems with backtracking.
 *
 * @author Koffman and Wolfgang
 **/
public class Maze implements GridColors {


    /**
     * The maze
     */
    private TwoDimGrid maze;

    public Maze(TwoDimGrid m) {
        maze = m;
    }

    /**
     * Wrapper method.
     */
    public boolean findMazePath() {
        return findMazePath(0, 0); // (0, 0) is the start point.
    }

    /**
     * Attempts to find a path through point (x, y).
     *
     * @param x The x-coordinate of current point
     * @param y The y-coordinate of current point
     * @return If a path through (x, y) is found, true;
     * otherwise, false
     * @pre Possible path cells are in BACKGROUND color;
     * barrier cells are in ABNORMAL color.
     * @post If a path is found, all cells on it are set to the
     * PATH color; all cells that were visited but are
     * not on the path are in the TEMPORARY color.
     */
    public boolean findMazePath(int x, int y) {
        // COMPLETE HERE FOR PROBLEM 1

        //return fase if point not in grid
        if (x < 0 || y < 0 || x >= maze.getNCols() || y >= maze.getNRows()) {
            return false;
        }
        //return false if point isnt part of path
        else if (!maze.getColor(x, y).equals(NON_BACKGROUND)) {
            return false;
        }
        //return true if point is the exit
        else if (x == maze.getNCols() - 1 && y == maze.getNRows() - 1) {
            maze.recolor(x, y, PATH);
            return true;
        }
        //set point to the "path" if exit isnt at the point
        else {
            maze.recolor(x, y, PATH);

            //return true if the neighbor of the point is the exit
            if (findMazePath(x - 1, y) || findMazePath(x + 1, y) || findMazePath(x, y + 1) || findMazePath(x, y - 1)) {
                return true;
            }

            //recolor the point to "temporary"
            else {
                maze.recolor(x, y, TEMPORARY);
                return false;
            }
        }
    }


    // ADD METHOD FOR PROBLEM 2 HERE
    public void findMazePathStackBased(int x, int y, ArrayList<ArrayList<PairInt>> result, Stack<PairInt> trace) {
        if (x < 0 || y < 0 || x > maze.getNCols() - 1 || y > maze.getNRows() - 1 || (!maze.getColor(x, y).equals(NON_BACKGROUND))) {
            return;
        }
        else if (x == maze.getNCols() - 1 && y == maze.getNRows() - 1) {
            trace.push(new PairInt(x, y));
            ArrayList<PairInt> cur = new ArrayList<>(trace);
            result.add(cur);
            trace.pop();

            return;
        }
        else {
            trace.push(new PairInt(x, y));
            maze.recolor(x, y, PATH);
            findMazePathStackBased(x + 1, y, result, trace);
            findMazePathStackBased(x - 1, y, result, trace);
            findMazePathStackBased(x, y + 1, result, trace);
            findMazePathStackBased(x, y - 1, result, trace);
            maze.recolor(x, y, NON_BACKGROUND);
            trace.pop();

            return;
        }
    }


    public ArrayList<ArrayList<PairInt>> findAllMazePaths(int x, int y) {
        ArrayList<ArrayList<PairInt>> result = new ArrayList<>();
        Stack<PairInt> trace = new Stack<>();
        findMazePathStackBased(0, 0, result, trace);
        return result;
    }

    //ADD METHOD FOR PROBLEM 3 HERE
    public ArrayList<PairInt> findMazePathMin(int x, int y) {
        int pathIndex = 0;
        int minimum;
        int[] counter;

        ArrayList<ArrayList<PairInt>> allPaths = findAllMazePaths(x, y); // 4 solutions, 4 3 8 4

        if (allPaths.size()==0) {
            ArrayList<PairInt> arrayTest = new ArrayList<>();
            return arrayTest;

        }
        else {
        counter = new int[allPaths.size()]; // count = 4
        for (int i = 0; i < allPaths.size(); i++) { // going through all the paths
            counter[i] = allPaths.get(i).size();
        }
        minimum = counter[0];
        for (int i = 1; i < counter.length; i++) {
            if (counter[i] < minimum) {
                minimum = counter[i];
                pathIndex = i;
            }
        }

        return allPaths.get(pathIndex);
        }
    }


    /*<exercise chapter="5" section="6" type="programming" number="2">*/
    public void resetTemp() {
        maze.recolor(TEMPORARY, BACKGROUND);
    }
    /*</exercise>*/

    /*<exercise chapter="5" section="6" type="programming" number="3">*/
    public void restore() {
        resetTemp();
        maze.recolor(PATH, BACKGROUND);
        maze.recolor(NON_BACKGROUND, BACKGROUND);
    }
    /*</exercise>*/
}
/*</listing>*/

