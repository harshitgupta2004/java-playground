// Given a stream of characters and we have to find first non repeating character each time a character is inserted to the stream. 

// TC = SC = O(n)

import java.util.LinkedList;
import java.util.Queue;

public class NonRepeating_Char_Stream {
    public static void firstNonRepeating(String str) {
        int count[] = new int[26];
        Queue<Character> q = new LinkedList<Character>();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            q.add(c);
            count[c - 'a']++;

            // check for the non repeating character
            while (!q.isEmpty()) {
                if (count[q.peek() - 'a'] > 1) {
                    q.remove();
                } else {
                    System.out.print(q.peek() + " ");
                    break;
                }
            }

            if (q.isEmpty()) {
                System.out.print(-1 + " ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        String str = "aabc";
        firstNonRepeating(str);
    }
}
