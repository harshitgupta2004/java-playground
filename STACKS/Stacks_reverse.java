import java.util.Stack;

public class Stacks_reverse {
    public static void pushAtBottom(Stack<Integer> s, int data) {
        if(s.isEmpty()) {
            s.push(data);
            return;
        }
        int top = s.pop();
        // call for next level
        pushAtBottom(s, data);
        // push the element again, which we removed
        s.push(top);
    }

    public static void reverseStack(Stack<Integer> s) {
        if(s.isEmpty()) {
            return;
        }

        int top = s.pop(); // removing top element
        reverseStack(s); //next call
        pushAtBottom(s, top); // push at bottom
    }

    public static void printStack(Stack<Integer> s) {
        while(! s.isEmpty()) {
            System.out.println(s.pop());
        }
    }

    public static void main(String args[]) {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        // 3, 2, 1

        reverseStack(s);
        printStack(s);
        // 1, 2, 3
    }
}
