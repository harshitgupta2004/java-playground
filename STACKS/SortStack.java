// Given a stack, the task is to sort it using recursion
// TC = O(n^2); SC = O(n)

import java.util.Stack;

public class SortStack {
    public static void sortStack(Stack<Integer> s){
        if(s.empty()){
            return;
        }

        // remove top elm
        int x = s.pop();

        // recursive call for remaining elms in stack
        sortStack(s);

        Stack<Integer> temp = new Stack<>();
        // Move all elements that are greater than x from the main stack to the tempStack
        while(!s.empty() && s.peek() > x){
            temp.push(s.pop());
        }

        s.push(x);
        while(!temp.empty()){
            s.push(temp.pop());
        }
    }
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
 
        // Push elements into the stack
        s.push(34);
        s.push(3);
        s.push(31);
        s.push(98);
        s.push(92);
        s.push(23);
 
        // Sort the stack
        sortStack(s);
 
        // Print the sorted elements
        System.out.print("Sorted numbers are: ");
        while (!s.empty()) {
            System.out.print(s.pop() + " ");
        }
    }
}
