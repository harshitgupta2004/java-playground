import java.util.Stack;

public class Duplicate_Paranthese {

    public static boolean isDuplicate(String str) {
        Stack<Character> s = new Stack<>();

        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            // Closing
            if(ch == ')') {
                int count = 0;
                while(s.peek() != '(') {
                    s.pop();
                    count++;
                }
                if(count < 1) {
                    return true; // duplicate exists
                } else {
                    s.pop(); // pop the opening pair
                }
            } else {
                // opening condition
                s.push(ch);
            }
        }

        return false;
    }
    public static void main(String args[]) {
        String str = " ((a+b)) "; // true
        String str2 = "(a-b)"; // false
        System.out.println(isDuplicate(str));
        System.out.println(isDuplicate(str2));
    }
}
