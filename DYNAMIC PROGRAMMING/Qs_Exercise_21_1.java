// Tribonacci Numbers
// The Tribonacci series is a generalization of the Fibonacci sequence where each term is the sum of the three preceding terms.
// a(n) = a(n-1) + a(n-2) + a(n-3) with a(0) = a(1) = 0, a(2) = 1

// TC = SC = O(n)

public class Qs_Exercise_21_1 {
    public static void printTrib(int n) {
        int dp[] = new int[n];
        dp[0] = dp[1] = 0;
        dp[2] = 1;

        for(int i = 3; i < n; i++){
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }

        for(int i = 0; i < n; i++){
            System.out.print(dp[i] + " ");
        }
    }

    public static void main(String[] args) {
        int n = 10;
        printTrib(n);
    }
}
