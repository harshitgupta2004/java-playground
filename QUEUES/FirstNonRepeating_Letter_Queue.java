import java.util.*;

// TC = O(n)
public class FirstNonRepeating_Letter_Queue {

    public static void printNonRepeating(String str) {
        int freq[] = new int[26]; // 'a' to 'z'
        Queue<Character> q = new LinkedList<>();

        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            q.add(ch);
            freq[ch-'a']++; // incr freq of that char

            while(! q.isEmpty() && freq[q.peek()-'a'] > 1){ // when q is not empty and the freq of char at front is > 1, so remove it
                q.remove();
            }

            if(q.isEmpty()) {
                System.out.print(-1 + " ");
            }
            else {
                System.out.print(q.peek()+" "); // char at front of q is non repeating
            }
        }
        System.out.println();
    }
    public static void main(String args[]) {
        String str = "aabccxb";
        printNonRepeating(str);
    }
}
