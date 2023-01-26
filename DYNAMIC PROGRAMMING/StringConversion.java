public class StringConversion {
    public static int lcs(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();

        int dp[][] = new int [n+1][m+1];
        for(int i = 0; i < n+1; i++){
            for(int j = 0; j < m+1; j++){
                if(i == 0 || j == 0) {
                    dp[i][j] = 0;
                }
            }
        }

        for(int i = 1; i < n+1; i++){
            for(int j = 1; j < m+1; j++){
                if(str1.charAt(i-1) == str2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    int ans1 = dp[i-1][j];
                    int ans2 = dp[i][j-1];
                    dp[i][j] = Math.max(ans1, ans2);
                }
            }
        }

        return dp[n][m];
    }

    public static void numOfDeletionInsertion(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        int len = lcs(str1, str2);

        int x = n - len; // no of delete operation
        int y = m - len; // no of insertions

        System.out.println("Number of deletions = " + x);
        System.out.println("Number of insertions = " + y);
    }
    public static void main(String[] args) {
        String str1 = "pear";
        String str2 = "sea";
        numOfDeletionInsertion(str1, str2);
    }
}
