public class WildcardMatching {
    // O(n*m) - HARD Level Problem
    public static boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();

        boolean dp[][] = new boolean[n+1][m+1];

        // initialize
        dp[0][0] = true;
        // pattern = " "
        for(int i = 1; i < n+1; i++){
            dp[i][0] = false;
        }
        // String  = " "
        for(int j = 1; j < m+1; j++){
            if(p.charAt(j-1) == '*'){ // jth char at j-1 idx
                dp[0][j] = dp[0][j-1];
            } // no need to write else case, as by default, boolean arr initialized with false in java
        }

        // bottop up
        for(int i = 1; i < n+1; i++){
            for(int j = 1; j < m+1; j++){
                // case -> ith cahr == jth char || jth char = ?
                if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?'){
                    dp[i][j] = dp[i-1][j-1];
                } else if(p.charAt(j-1) == '*'){
                    dp[i][j] = dp[i-1][j] || dp[i][j-1];
                } else {
                    dp[i][j] = false;
                }
            }
        }

        // final ans -> string -> n, pattern -> m
        return dp[n][m];
    }
    public static void main(String[] args) {
        String s = "baaabab";
        String p = "*****ba*****ab";
        System.out.println(isMatch(s, p));
    }
}