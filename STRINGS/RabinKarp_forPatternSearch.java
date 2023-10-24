public class RabinKarp_forPatternSearch {
    public final static int d = 256;

    public static void search(String txt, String pat, int q) {
        int n = txt.length();
        int m = pat.length();
        int i, j;
        int p = 0; // hash value for pattern
        int t = 0; // hash value for text
        int h = 1; // h = (d^m-1)%q

        for (i = 0; i < m - 1; i++) {
            h = (h * d) % q;
        }

        // Calculate the hash value of pattern and first window of text
        for (i = 0; i < m; i++) {
            p = (d * p + pat.charAt(i)) % q;
            t = (d * t + txt.charAt(i)) % q;
        }

        // Slide the pattern over text one by one
        for (i = 0; i <= n - m; i++) {
            // Check the hash values of current window of text and pattern. If the hash
            // values match
            // then only check for characters one by one
            if (p == t) {
                // check for chars one by one
                for (j = 0; j < m; j++) {
                    if (txt.charAt(i + j) != pat.charAt(j)) {
                        break;
                    }
                }

                if (j == m) {
                    System.out.println("Pattern found at index : " + i);
                }
            }

            // Calculate hash value for next window of text: Remove leading digit, add
            // trailing digit
            if (i < n - m) {
                t = (d * (t - txt.charAt(i) * h) + txt.charAt(i + m)) % q;

                // we may get -ve value of t, so convert into +ve
                if (t < 0) {
                    t = t + q;
                }
            }
        }
    }

    public static void main(String[] args) {
        String txt = "AABAACAADAABAABA";
        String pat = "AABA";

        // A prime number
        int q = 101;

        search(txt, pat, q);
    }
}
