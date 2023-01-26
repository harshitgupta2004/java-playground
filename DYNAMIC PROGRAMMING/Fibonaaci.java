public class Fibonaaci {
    
    // MEMOIZATION
    public static int fib(int n, int f[]) {
        if(n == 0 || n == 1) {
            return n;
        }
        if(f[n] != 0) { // fib(n) is already calculated
            return f[n];
        } 
        f[n] = fib(n-1, f) + fib(n-2, f); // and if not already cal, then, add it to f array means not calculated, so cal again
        return f[n];
    }

    // TABULATION
    public static int fibTabulation(int n) {
        int dp[] = new int[n+1]; // we are starting from 0
        dp[0] = 0;
        dp[1] = 1;
        for(int i = 2; i <= n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n]; // ans
    }
    public static void main(String[] args) {
        int n = 5;
        // to store all fibonacci, we use f array
        int f[] = new int[n+1]; // Intially, By default, it stores 0 at all indexes -> 0, 0, 0, 0
        System.out.println(fib(n, f));

        System.out.println(fibTabulation(n));
    }
}