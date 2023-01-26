// Swapping Nodes in a Linked List
// We have a linked list and two keys in it, swap nodes for two given keys. Nodes should be swapped by changing links. Swapping data of nodes maybe expensive in many situations when data contains many fields. 
// It may be assumed that all keys in the linked list are distinct.

// TC = O(n)
// SC = O(1)



public class Qs_Exercise12_3 {

    class Node {
        int data;
        Node next;
        Node(int d) {
            data = d;
            next = null;
        }
    }

    Node head;

    public void swapNodes(int x, int y) {
        if(x == y) {
            return;
        }

        Node prevX = null, currX = head;
        while(currX != null && currX.data != x) {
            prevX = currX;
            currX = currX.next;
        }

        Node prevY = null, currY = head;
        while(currY != null && currY.data != y) {
            prevY = currY;
            currY = currY.next;
        }

        if(currX == null || currY == null) {
            return;
        }
        if(prevX != null) {
            prevX.next = currY;
        } else {
            head = currY;
        }
        if(prevY != null) {
            prevY.next = currX;
        } else {
            head = currX;
        }

        Node temp = currX.next;
        currX.next = currY.next;
        currY.next = temp;
    }

    public void push(int newdata) {
        Node newNode = new Node(newdata);
        newNode.next = head;
        head = newNode;
    }

    public void print() {
        Node tNode = head;
        while(tNode != null) {
            System.out.print(tNode.data+" ");
            tNode = tNode.next;
        }
    }
    public static void main(String args[]) {
        Qs_Exercise12_3 llist = new Qs_Exercise12_3();

        llist.push(7);
        llist.push(6);
        llist.push(5);
        llist.push(4);
        llist.push(3);
        llist.push(2);
        llist.push(1);

        System.out.println("Linked List before:");
        llist.print();
        System.out.println();

        llist.swapNodes(4, 3);

        System.out.println("LL after:");
        llist.print();
    }
}
