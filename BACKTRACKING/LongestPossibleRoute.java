/* Given an M x N matrix, with a few hurdles arbitrarily placed, calculate the length of the longest possible route possible from source to a destination within the matrix. We are allowed to move to only adjacent cells which are not hurdles. The route cannot contain any diagonal moves and a location once visited in a particular path cannot be visited again. */
// TC = O(4^n) as there are 4 possible directions;  SC = O(1)

public class LongestPossibleRoute {
    // 'ans' is -1 if we can't reach
    // 'cur' is the number of steps we have traversed
    public static int findLongestPath(int mat[][], int i, int j, int di, int dj, int n, int m, int curr, int ans) {
        // if reach dest
        if (i == di && j == dj) {
            if (curr > ans) {
                ans = curr;
            }
        }

        // if src or dest is hurdle itself
        if (mat[i][j] == 0 || mat[di][dj] == 0) {
            return ans;
        }

        // mark as vis
        mat[i][j] = 0;

        // checking if we reach dest going right
        if (j != m - 1 && mat[i][j + 1] > 0) {
            ans = findLongestPath(mat, i, j + 1, di, dj, n, m, curr + 1, ans);
        }

        // left
        if (j != 0 && mat[i][j - 1] > 0) {
            ans = findLongestPath(mat, i, j - 1, di, dj, n, m, curr + 1, ans);
        }

        // up
        if (i != 0 && mat[i - 1][j] > 0) {
            ans = findLongestPath(mat, i - 1, j, di, dj, n, m, curr + 1, ans);
        }

        // down
        if (i != n - 1 && mat[i + 1][j] > 0) {
            ans = findLongestPath(mat, i + 1, j, di, dj, n, m, curr + 1, ans);
        }

        // marking visited to backtrack
        mat[i][j] = 1;

        return ans;
    }

    public static void main(String[] args) {
        int[][] mat = { { 1, 1, 1, 1 },
                { 1, 1, 0, 1 },
                { 1, 1, 1, 1 } };

        // Find the longest path with source (0, 0) and destination (2, 3)
        int result = findLongestPath(mat, 0, 0, 2, 3, mat.length, mat[0].length, 0, -1);
        System.out.println(result);
    }
}
