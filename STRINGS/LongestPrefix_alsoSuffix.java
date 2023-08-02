public class LongestPrefix_alsoSuffix {

    // Approach 1 : Since overlapping prefixes and suffixes is not allowed, we break the string
    // from the middle and start matching left and right strings. If they are equal
    // return size of one string, else they try for shorter lengths on both sides.
    // O(N^2) TC & O(1) SC
    public static int longestPrefixSuffix(String s) {
        int n = s.length();
        if (n < 2) {
            return 0;
        }

        int len = 0;
        int i = (n + 1) >> 2;
        while (i < n) {
            if (s.charAt(i) == s.charAt(len)) {
                len++;
                i++;
            } else {
                i = i - len + 1;
                len = 0;
            }
        }
        return len;
    }

    /* Approach 2 : Maintain two pointers: one at the end of string(for suffix) & one starts at the middle of
    string(for prefix). If they match, decrement both the pointers. When a mismatch occurs, reset the 
    suffix pointer back to end of string and repeat. When prefix pointer reaches ‘-1’ (string is exhausted)
    the longest common suffix/prefix will be the substring from suffix pointer to end of the string.*/ 
    // TC O(N) SC O(1)

    public static int longestPrefixSuffix2(String s){
        int n = s.length();
        if(n == 0){
            return 0;
        }

        int endSuffix = n-1;
        int endPrefix = n/2-1;

        while(endPrefix >= 0){
            if(s.charAt(endSuffix) != s.charAt(endPrefix)){
                if(endSuffix != n-1){
                    endSuffix = n-1;
                }else{
                    endPrefix--;
                }
            }else{
                endPrefix--;
                endSuffix--;
            }
        }

        return n-endSuffix-1;
    }

    public static void main(String[] args) {
        String s = "abcaabc";
        System.out.println(longestPrefixSuffix(s));
        System.out.println(longestPrefixSuffix2(s));
    }
}
