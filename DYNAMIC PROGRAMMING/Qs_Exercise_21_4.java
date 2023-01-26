import java.util.Arrays;

// Longest Increasing Path in Matrix
// We have a matrix of N rows and M columns. From m[i][j], we can move to m[i+1][j], if m[i+1][j] > m[i][j], or can move to m[i][j+1] if m[i][j+1] > m[i][j]. 
// The task is to print the longest path length if we start from (0, 0).

// TC = SC = O(n^2)

public class Qs_Exercise_21_4 {
    public static int LIP(int dp[][], int mat[][], int n, int m, int x, int y) {
        if(dp[x][y] < 0) {
            int result = 0;
            if(x == n-1 && y == m-1){
                return dp[x][y] = 1;
            }
            if(x == n-1 || y == m-1){
                result = 1;
            }
            if(x+1 < n && mat[x][y] < mat[x+1][y]) {
                result = 1 + LIP(dp, mat, n, m, x+1, y);
            }
            if(y+1 < m && mat[x][y] < mat[x][y+1]){
                result = Math.max(result, 1 + LIP(dp, mat, n, m, x, y+1));
            }
            dp[x][y] = result;
        }

        return dp[x][y];
    }

    public static int wrapper(int mat[][], int n, int m) {
        int dp[][] = new int[10][10];
        for(int i = 0; i < 10; i++){
            Arrays.fill(dp[i], -1);
        }
        return LIP(dp, mat, n, m, 0, 0);
    }

    public static void main(String[] args) {
        int mat[][] = {{ 1, 2, 3, 4 },
                       { 2, 2, 3, 4 },
                       { 3, 2, 3, 4 },
                       { 4, 5, 6, 7 }};

        int n = 4, m = 4;
        System.out.println(wrapper(mat, n, n));
    }
}
