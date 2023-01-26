public class MountainRanges {
    
    // O(n^2)
    public static int mountainRange(int n) {
        int dp[] = new int[n+1];
        dp[0] = dp[1] = 1;

        for(int i = 2; i <= n; i++){ // Ci -> i pairs -> mountaing ranges
            for(int j = 0; j < i; j++){
                int inside = dp[j];
                int outside = dp[i-j-1];
                dp[i] += inside * outside;
            }
        }

        return dp[n];
    }
    public static void main(String[] args) {
        int n = 4;
        System.out.println(mountainRange(n));
    }
}
