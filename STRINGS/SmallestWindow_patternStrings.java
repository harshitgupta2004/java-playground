public class SmallestWindow_patternStrings {
    public static String findSubString(String str, String pat) {
        int n = str.length();
        int m = pat.length();

        if (n < m) {
            System.out.println("No Window Exist");
            return "";
        }

        int hashStr[] = new int[256];
        int hashPat[] = new int[256];

        // Store occurrence of characters of pattern
        for (int i = 0; i < m; i++) {
            hashPat[pat.charAt(i)]++;
        }

        int start = 0, startIdx = -1, min_len = Integer.MAX_VALUE;

        int count = 0;
        // traversing th string
        for (int j = 0; j < n; j++) {
            hashStr[str.charAt(j)]++;

            // If string's char matches with pattern's char then increment count
            if (hashStr[str.charAt(j)] <= hashPat[str.charAt(j)]) {
                count++;
            }

            // if all chars are matched
            if (count == m) {
                // try to minimize the window
                while (hashStr[str.charAt(start)] > hashPat[str.charAt(start)] || hashPat[str.charAt(start)] == 0) {
                    if (hashStr[str.charAt(start)] > hashPat[str.charAt(start)]) {
                        hashStr[str.charAt(start)]--;
                        start++;
                    }
                }

                // updated window size
                int len = j - start + 1;
                if (min_len > len) {
                    min_len = len;
                    startIdx = start;
                }
            }
        }

        // if no window found
        if (startIdx == -1) {
            System.out.println("No Window Exist");
            return "";
        }

        return str.substring(startIdx, startIdx + min_len);

    }

    public static void main(String[] args) {
        String str = "this is a test string";
        String pat = "tist";

        System.out.print(findSubString(str, pat));
    }
}