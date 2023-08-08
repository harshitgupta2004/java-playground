// An expression will be given which can contain open and close parentheses and optionally some characters, No other operator will be there in string. We need to remove minimum number of parentheses to make the input string valid. If more than one valid output are possible removing same number of parentheses then print all such output
// TC = SC = O(2^n) : worst case

import java.util.HashSet;
import java.util.Queue;
import java.util.LinkedList;

public class RemoveInvalid_Parantheses {
    // method checks if character is parenthesis(open or closed)
    public static boolean isParatheses(char c) {
        return ((c == '(') || (c == ')'));
    }

    // method returns true if string contains valid parenthesis
    public static boolean isValidString(String str) {
        int cnt = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                cnt++;
            } else if (str.charAt(i) == ')') {
                cnt--;
            }

            if (cnt < 0) {
                return false;
            }
        }

        return (cnt == 0);
    }

    public static void removeInvalidParenthesis(String str) {
        if (str.isEmpty()) {
            return;
        }

        // visit set to ignore already visited string
        HashSet<String> visit = new HashSet<String>();

        // queue to maintain BFS
        Queue<String> q = new LinkedList<>();
        String temp;
        boolean level = false;

        // pushing given string as starting node into queue
        q.add(str);
        visit.add(str);
        while (!q.isEmpty()) {
            str = q.peek();
            q.remove();
            if (isValidString(str)) {
                System.out.println(str);
                // If answer is found, make level true so that valid string of only that level are processed.
                level = true;
            }

            if (level) {
                continue;
            }

            for (int i = 0; i < str.length(); i++) {
                if (!isParatheses(str.charAt(i))) {
                    continue;
                }

                // Removing parenthesis from str and pushing into queue, if not visited already
                temp = str.substring(0, i) + str.substring(i + 1);
                if (!visit.contains(temp)) {
                    q.add(temp);
                    visit.add(temp);
                }
            }
        }

    }

    public static void main(String[] args) {
        String expression = "()())()";
        removeInvalidParenthesis(expression);

        expression = "()v)";
        removeInvalidParenthesis(expression);
    }
}
