import java.util.*;

public class Stack_UsingDeque {

    static class Stack {
        Deque <Integer> deque = new LinkedList<>();

        // Push
        public void push(int data) {
            deque.addLast(data);
        }

        // Pop
        public int pop() {
            return deque.removeLast();
        }

        // Peek
        public int peek() {
            return deque.getLast();
        }
    }
    public static void main(String args[]) {
        Stack s = new Stack(); // this Stack is not from JCF, this Stack is formed only in the form of deque
        s.push(1);
        s.push(2);
        s.push(3);

        System.out.println("Peek = " + s.peek());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
    }
}
