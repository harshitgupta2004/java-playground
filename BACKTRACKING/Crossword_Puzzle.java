/* A 10 x 10 Crossword grid is provided, along with a set of words (or names of places) which need to be filled into the grid. The cells in the grid are initially, either + signs or – signs. Cells marked with a ‘+’ have to be left as they are. Cells marked with a ‘-‘ need to be filled up with an appropriate character. You are also given an array of words that need to be filled in Crossword grid. */

import java.util.*;

public class Crossword_Puzzle {
    static int ways = 0;

    public static void printMatrix(List<String> matrix, int n) {
        for (int i = 0; i < n; i++) {
            System.out.println(matrix.get(i));
        }
    }

    public static List<String> horizontal(int x, int y, List<String> matrix, String currWord) {
        int n = currWord.length();

        for (int i = 0; i < n; i++) {
            if (matrix.get(x).charAt(y + i) == '#' || matrix.get(x).charAt(y + i) == currWord.charAt(i)) {
                StringBuilder sb = new StringBuilder(matrix.get(x));
                sb.setCharAt(y + i, currWord.charAt(i));
                matrix.set(x, sb.toString());
            } else {
                matrix.set(0, "@");
                return matrix;
            }
        }

        return matrix;
    }

    public static List<String> vertical(int x, int y, List<String> matrix, String currWord) {
        int n = currWord.length();

        for (int i = 0; i < n; i++) {
            if (matrix.get(x + i).charAt(y) == '#' || matrix.get(x + i).charAt(y) == currWord.charAt(i)) {
                StringBuilder sb = new StringBuilder(matrix.get(x + i));
                sb.setCharAt(y, currWord.charAt(i));
                matrix.set(x + i, sb.toString());
            } else {
                matrix.set(0, "@");
                return matrix;
            }
        }

        return matrix;
    }

    public static void solvePuzzle(List<String> words, List<String> matrix, int idx, int n) {
        if (idx < words.size()) {
            String currWord = words.get(idx);
            int maxLen = n - currWord.length();

            // vertical align
            for (int i = 0; i < n; i++) {
                for (int j = 0; j <= maxLen; j++) {
                    List<String> temp = new ArrayList<>(vertical(j, i, new ArrayList<>(matrix), currWord));
                    if (!temp.get(0).equals("@")) {
                        solvePuzzle(words, temp, idx + 1, n);
                    }
                }
            }

            // horizontal
            for (int i = 0; i < n; i++) {
                for (int j = 0; j <= maxLen; j++) {
                    List<String> temp = new ArrayList<>(horizontal(i, j, new ArrayList<>(matrix), currWord));
                    if (!temp.get(0).equals("@")) {
                        solvePuzzle(words, temp, idx + 1, n);
                    }
                }
            }
        } else {
            System.out.println(ways + 1);
            printMatrix(matrix, n);
            System.out.println();

            // increase the ways
            ways++;
            return;
        }
    }

    public static void main(String[] args) {
        int n1 = 10;

        // matrix to hold the grid of puzzle
        List<String> matrix = new ArrayList<>();

        matrix.add("*#********");
        matrix.add("*#********");
        matrix.add("*#****#***");
        matrix.add("*##***##**");
        matrix.add("*#****#***");
        matrix.add("*#****#***");
        matrix.add("*#****#***");
        matrix.add("*#*######*");
        matrix.add("*#********");
        matrix.add("***#######");

        List<String> words = new ArrayList<>();

        // the words matrix will hold all the words need to be filled in the grid
        words.add("PUNJAB");
        words.add("JHARKHAND");
        words.add("MIZORAM");
        words.add("MUMBAI");

        // initialize the number of ways to solve the puzzle to zero
        ways = 0;

        // Here 0 is the initial index of words array n1 is length of grid
        solvePuzzle(words, matrix, 0, n1);
        System.out.println("Number of ways to fill the grid is " + ways);
    }
}
