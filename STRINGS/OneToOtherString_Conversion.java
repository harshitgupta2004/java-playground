/* Given two strings A and B, the task is to convert A to B if possible. The only operation allowed is to put any character from A and insert it at front. Find if it’s possible to convert the string. If yes, then output minimum no. of operations required for transformation */

public class OneToOtherString_Conversion {
    public static int minOps(String a, String b) {
        if (a.length() != b.length()) {
            return -1;
        }

        int i, j, res = 0;
        int count[] = new int[256];

        // count characters in A , subtract count for every character in B
        for (i = 0; i < a.length(); i++) {
            count[a.charAt(i)]++;
            count[b.charAt(i)]--;
        }

        // check if all counts become 0
        for (i = 0; i < 256; i++) {
            if (count[i] != 0) {
                return -1;
            }
        }

        i = a.length() - 1;
        j = b.length() - 1;

        while (i >= 0) {
            if (a.charAt(i) != b.charAt(j)) {
                res++;
            } else {
                j--;
            }

            i--;
        }

        return res;
    }

    public static void main(String[] args) {
        String A = "EACBD";
        String B = "EABCD";

        System.out.println("Minimum number of operations required is " + minOps(A, B));
    }
}
