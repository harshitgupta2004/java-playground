import java.util.Scanner;

public class Remove_ConsecutiveChar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        StringBuilder sb = new StringBuilder(s);

        for (int i = sb.length() - 1; i > 0; i--) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                sb.deleteCharAt(i);
            }
        }

        String s1 = sb.toString();
        System.out.println(s1);
    }
}
