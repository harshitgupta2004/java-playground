/* A celebrity is a person who is known to all but does not know anyone at a party. If you go to a party of N people, find if there is a celebrity in the party or not.
A square NxN matrix M[][] is used to represent people at the party such that if an element of row i and column j  is set to 1 it means ith person knows jth person. Here M[i][i] will always be 0. */

// T = O(N), Iterating two times the array of size N ; SC = O(1)

public class CelebrityProblem {
    public static int celebrity(int mat[][], int n) {
        int i = 0, j = n - 1;
        while (i < j) {
            if (mat[i][j] == 1) { // i knows j then i can’t be a celebrity so increment i
                i++;
            } else { // j cannot be a celebrity, so decrement j
                j--;
            }
        }

        // i points to our celebrity candidate
        int candidate = i;

        for (int k = 0; i < n; i++) {
            if (k != candidate) {
                if (mat[k][candidate] == 0 || mat[candidate][k] == 1) {
                    return -1;
                }
            }
        }

        return candidate;
    }

    public static void main(String[] args) {
        int[][] M = { { 0, 0, 1, 0 },
                { 0, 0, 1, 0 },
                { 0, 0, 0, 0 },
                { 0, 0, 1, 0 } };

        int celebIdx = celebrity(M, 4);

        if (celebIdx == -1)
            System.out.println("No Celebrity");
        else {
            System.out.println("Celebrity ID : " + celebIdx);
        }
    }
}
