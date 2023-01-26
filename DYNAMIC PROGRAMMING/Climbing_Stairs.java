import java.util.Arrays;

public class Climbing_Stairs {
    // Memoization -> O(n) | recursion -> O(2^n)
    public static int countWays(int n, int ways[]) {
        if(n == 0 ){
            return 1;
        }
        if(n < 0){
            return 0;
        }

        if(ways[n] != -1){ // already calculated
            return ways[n];
        }
        ways[n] = countWays(n-1, ways) + countWays(n-2, ways);
        return ways[n];
    }

    // Tabulation - O(n)
    public static int countWaysTab(int n) {
        int dp[] = new int[n+1]; // 0 to n
        dp[0] = 1;

        // tabulation loop
        for(int i = 1; i <= n; i++){
            if(i == 1){
                dp[i] = dp[i-1];
            } else {
                dp[i] = dp[i-1] + dp[i-2];
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        int n = 5; //  n = 3 -> 3 & n = 4 -> 5 ways => 8 ways
        int ways[] = new int[n+1]; // 0 to n // by deafult, at every idx 0 stored in arr when initialize
        Arrays.fill(ways, -1); // -1 got filled at every idx
        System.out.println(countWays(n, ways));
        System.out.println(countWaysTab(n));
    }
}
