import java.util.Stack;

// Palindrome Linked List
// We have a singly linked list of characters, write a function that returns true if the given list is a palindrome, else false.

// TC = O(n)
// SC = O(n)

public class Qs_Exercise13_1 {

    static class Node {
        int data;
        Node ptr;
        Node(int d){
            ptr = null;
            data = d;
        }
    }

    static boolean isPalindrome(Node head) {

        Node slow = head;
        boolean ispalin = true;
        Stack<Integer> s = new Stack<>();

        while(slow != null) {
            s.push(slow.data);
            slow = slow.ptr;
        }

        while(head != null) {
            int i = s.pop();
            if(head.data == i) {
                ispalin = true;
            } else {
                ispalin = false;
                break;
            }
            head = head.ptr;
        }
        return ispalin;
    }
    public static void main(String args[]) {
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(3);
        Node six = new Node(2);
        Node seven = new Node(1);
        one.ptr = two;
        two.ptr = three;
        three.ptr = four;
        four.ptr = five;
        five.ptr = six;
        six.ptr = seven;
        
        boolean condition = isPalindrome(one);
        System.out.println("Palindrome : " + condition);
    }
}
