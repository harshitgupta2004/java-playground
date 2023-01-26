// Delete N Nodes After M Nodes of a Linked List
// We have a linked list and two integers M and N. Traverse the linked list such that you retain M
// nodes then delete next N nodes, continue the same till end of the linked list

// TC = O(n)
// SC = O(1)

import java.util.*;
public class Qs_Exercise12_2 {

    static class Node {
        int data;
        Node next;
    }

    static Node push(Node head_ref, int new_data) {
        Node new_Node = new Node();
        new_Node.data = new_data;
        new_Node.next = (head_ref);
        (head_ref) = new_Node;
        return head_ref;
    }

    static void print(Node head) {
        Node temp = head;
        while(temp != null) {
            System.out.printf("%d", temp.data);
            temp = temp.next;
        }
        System.out.println();
    }

    static void skipMdeleteN(Node head, int M, int N) {
        Node curr = head, t;
        int count;

        while(curr != null) {
            for(count = 1; count < M && curr != null; count++) {
                curr = curr.next;
            }
            if(curr == null) {
                return;
            }
            t = curr.next;
            for(count = 1; count <= N && t != null; count++) {
                Node temp = t;
                t = t.next;
            }

            curr.next = t;
            curr = t;
        }
    }
    public static void main(String args[]) {
        Node head = null;
        int M = 3, N = 2;

        head = push(head, 10);
        head = push(head, 9);
        head = push(head, 8);
        head = push(head, 7);
        head = push(head, 6);
        head = push(head, 5);
        head = push(head, 4);
        head = push(head, 3);
        head = push(head, 2);
        head = push(head, 1);

        System.out.printf("M = %d, N = %d\n" + "Linked list we have is:\n", M, N);

        print(head);

        skipMdeleteN(head, M, N);

        System.out.printf("\nLinked list on deletion is:\n");
        print(head);
    }
}
