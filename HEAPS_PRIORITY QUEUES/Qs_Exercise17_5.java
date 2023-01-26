// Merge K Sorted Linked List
// We have K linked lists each of size N and each list is sorted in non-decreasing order, merge them into a single sorted (non-decreasing order) linked list and print the sorted linked list as output

// TC = O(n*k*logk)
// SC = O(k)

import java.io.*;
import java.util.*;

public class Qs_Exercise17_5 {

    class Node{
        int data;
        Node next;
    
        Node(int key){
            data = key;
            next = null;
        }
    }
    
    class NodeComparator implements Comparator<Node> {
        public int compare(Node k1, Node k2){
            if(k1.data > k2.data){
                return 1;
            } else if(k1.data < k2.data){
                return -1;
            }
            return 0;
        }
    }
   
    static Node mergeKList(Node arr[], int k){
        PriorityQueue<Node> queue = new PriorityQueue<>();
        Node at[] = new Node[k];
        Node head = new Node(0);
        Node last = head;
        for(int i = 0; i < k; i++){
            if(arr[i] != null){
                queue.add(arr[i]);
            }
        }

        if(queue.isEmpty()){
            return null;
        }
        while(! queue.isEmpty()){
            Node curr = queue.poll();
            last.next = curr;
            last = last.next;
            if(curr.next != null){
                queue.add(curr.next);
            }
        }
        return head.next;
    }

    public static void printList(Node node) {
        while(node != null){
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    public static void main(String args[]) {
        int n = 3;
        Node[] a = new Node[n];
        
        Node head1 = new Node(1);
        a[0] = head1;
        head1.next = new Node(3);
        head1.next.next = new Node(5);
        head1.next.next.next = new Node(7);
        
        Node head2 = new Node(2);
        a[1] = head2;
        head2.next = new Node(4);
        head2.next.next = new Node(6);
        head2.next.next.next = new Node(8);
        
        Node head3 = new Node(0);
        a[2] = head3;
        head3.next = new Node(9);
        head3.next.next = new Node(10);
        head3.next.next.next = new Node(11);
        
        Node res = mergeKList(a, n);
        
        if (res != null){
            printList(res);
        }

        System.out.println();
    }
}
