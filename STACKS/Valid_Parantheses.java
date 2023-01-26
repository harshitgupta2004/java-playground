import java.util.*;

public class Valid_Parantheses {

    public static boolean isValid(String str) {
        Stack <Character> s = new Stack<>();

        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i); // in this char, our backet is stored
            
            // opening
            if(ch == '(' || ch == '{' || ch == '[') {
                s.push(ch);
            } else {
                // closing
                if(s.isEmpty()) {
                    return false;
                }
                // check pair form
                if((s.peek() == '(' && ch == ')') // ()
                    || (s.peek() == '{' && ch == '}') // {}
                    || (s.peek() == '[' && ch == ']') ) { // []
                        s.pop();
                } else {
                    return false;
                }
            }
        }

        if(s.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
    public static void main(String args[]) {
        String str = "({})[]"; // true
        System.out.println(isValid(str));
    }
}