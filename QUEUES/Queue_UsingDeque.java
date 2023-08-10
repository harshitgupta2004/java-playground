import java.util.Deque;
import java.util.LinkedList;

public class Queue_UsingDeque {

    static class Queue {
        Deque<Integer> deque = new LinkedList<>();

        // Add
        public void add(int data) {
            deque.addLast(data);
        }

        // Remove
        public int remove() {
           return deque.removeFirst();
        }

        // Peek
        public int peek() {
           return deque.getFirst();
        }
    }
    public static void main(String args[]) {
        Queue q = new Queue(); // this Queue is not from JCF, this Queue is formed only in the form of deque

        q.add(1);
        q.add(2);
        q.add(3);

        System.out.println("Peek = "+ q.peek());
        System.out.println(q.remove());
        System.out.println(q.remove());
        System.out.println(q.remove());
    }
}
