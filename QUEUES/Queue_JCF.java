import java.util.*;
import java.util.LinkedList;

public class Queue_JCF {
    public static void main(String args[]) {
        // Queue q = new Queue(5);
        Queue<Integer> q = new LinkedList<>();
        Queue <Integer> q2 = new ArrayDeque<>();
        q.add(1);
        q.add(2);
        q.add(3);

        while(! q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();
        }
    }
}
