// TC = O(n*m) SC = O(1)

/* Given a matrix where every row is sorted in increasing order. Write a function that finds and returns a common element in all rows. If there is no common element, then returns -1 */

import java.util.*;

public class CommonElm_inAllRows {
    public static int findCommon(int mat[][], int n, int m) {
        // hashmap to store count of elms
        HashMap<Integer, Integer> count = new HashMap<Integer, Integer>();

        for (int i = 0; i < n; i++) {
            // Increment the count of first element of the row
            if (count.containsKey(mat[i][0])) {
                count.put(mat[i][0], count.get(mat[i][0]) + 1);
            } else {
                count.put(mat[i][0], 1);
            }

            // Starting from the second element of the current row
            for (int j = 1; j < m; j++) {

                // If current element is different from the previous element i.e.
                // it is appearing for the first time in the current row
                if (mat[i][j] != mat[i][j - 1]) {
                    if (count.containsKey(mat[i][j])) {
                        count.put(mat[i][j], count.get(mat[i][j]) + 1);
                    } else {
                        count.put(mat[i][j], 1);
                    }
                }
            }
        }

        // Find element having count equal to number of rows
        for (Map.Entry<Integer, Integer> elm : count.entrySet()) {
            if (elm.getValue() == n) {
                return elm.getKey();
            }
        }

        return -1;

    }

    public static void main(String[] args) {
        int mat[][] = { { 1, 2, 3, 4, 5 }, { 2, 4, 5, 8, 10 }, { 3, 5, 7, 9, 11 }, { 1, 3, 5, 7, 9 } };
        int n = mat.length;
        int m = mat[0].length;

        int result = findCommon(mat, n, m);
        if (result == -1) {
            System.out.print("No common element");
        } else {
            System.out.print("Common element is " + result);
        }
    }
}
