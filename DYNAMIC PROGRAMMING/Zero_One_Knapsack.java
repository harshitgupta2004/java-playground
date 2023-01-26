public class Zero_One_Knapsack {

    public static int knapsack(int val[], int wt[], int W, int n) {
        if(W == 0 || n == 0) { // n is item which we are talking about
            return 0;
        }

        if(wt[n-1] <= W){ // valid // 1st item -> its idx = 0; 2nd item -> idx = 1
            // include
            int ans1 = val[n-1] + knapsack(val, wt, W-wt[n-1], n-1); // add my profit to max profit from other remaining items / levels
            // exlude
            int ans2 = knapsack(val, wt, W, n-1);

            return Math.max(ans1, ans2); // max of both is my max profit
        } else { // not valid
            return knapsack(val, wt, W, n-1);
        }
    }

    // Memoization - O(n * W)
    public static int knapsackMemo(int val[], int wt[], int W, int n, int dp[][]) {
        if(W == 0 || n == 0) { 
            return 0;
        }

        if(dp[n][W] != -1){
            return dp[n][W];
        }

        if(wt[n-1] <= W){ // valid
            // include
            int ans1 = val[n-1] + knapsackMemo(val, wt, W-wt[n-1], n-1, dp);
            // exlude
            int ans2 = knapsackMemo(val, wt, W, n-1, dp);

            dp[n][W] = Math.max(ans1, ans2);
            return dp[n][W];
        } else { // not valid
            dp[n][W] = knapsackMemo(val, wt, W, n-1, dp);
            return dp[n][W];
        }
    }

    public static void print(int dp[][]) {
        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp[0].length; j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    // Tabulation - O(n*W)
    public static int knapsackTab(int val[], int wt[], int W) {
        int n = val.length;
        int dp[][] = new int[n+1][W+1];
        for(int i = 0; i < dp.length; i++){ // 0th col
            dp[i][0] = 0;
        }
        for(int j = 0; j < dp[0].length; j++){ // 0th row
            dp[0][j] = 0;
        }

        for(int i = 1; i < n+1; i++){
            for(int j = 0; j < W+1; j++){
                int v = val[i-1]; // ith item val
                int w = wt[i-1]; // ith item wt
                if(w <= j) { // valid
                    int incProfit = v + dp[i-1][j-w];
                    int excProfit = dp[i-1][j];
                    dp[i][j] = Math.max(incProfit, excProfit);
                } else { // invalid
                    int excProfit = dp[i-1][j];
                    dp[i][j] = excProfit;
                }
            }
        }

        print(dp);
        return dp[n][W];
    }
    public static void main(String[] args) {
        int val[] = {15, 14, 10, 45, 30};
        int wt[] = {2, 5, 1, 3, 4};
        int W = 7;

        int dp[][] = new int[val.length][wt.length];
        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp[0].length; j++){
                dp[i][j] = -1;
            }
        }

        //System.out.println(knapsack(val, wt, W, val.length));

        //System.out.println(knapsackMemo(val, wt, W, W, dp));

        System.out.println(knapsackTab(val, wt, W));
    }
}
