import java.util.Stack;

public class Stacks_bottom {

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
    public static void main(String args[]) {
        Stack <Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);

        pushAtBottom(s, 4);
        while(! s.isEmpty()) {
            System.out.println(s.pop());
        }        
    }
}
