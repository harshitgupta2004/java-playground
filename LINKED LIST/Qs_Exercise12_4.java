// Odd Even Linked List
// We have a Linked List of integers, write a function to modify the linked list such that all even numbers appear before all the odd numbers in the modified linked list. 
// Also,keep the order of even and odd numbers same

// TC = O(n)
// SC = O(1)

public class Qs_Exercise12_4 {
    Node head;
    class Node{
        int data;
        Node next;
        Node(int d){
            data = d;
            next = null;
        }
    }

    void segregateEvenOdd() {
        Node end = head;
        Node prev = null;
        Node curr = head;

        while(end.next != null) {
            end = end.next;
        }

        Node new_end = end;

        while(curr.data % 2 != 0 && curr != end){
            new_end.next = curr;
            curr = curr.next;
            new_end.next.next = null;
            new_end = new_end.next;
        }

        if(curr.data % 2 == 0) {
            head = curr;
            while(curr != end) {
                if(curr.data % 2 == 0) {
                    prev = curr;
                } else {
                    prev.next = curr.next;
                    curr.next = null;
                    new_end.next = curr;
                    new_end = curr;
                    curr = prev.next;
                }
            }
        }
        else {
            prev = curr;
        }
        if(new_end != end && end.data % 2 != 0) {
            prev.next = end.next;
            end.next = null;
            new_end.next = end;
        }
    }

    void push(int new_data){
        Node newNode = new Node(new_data);
        newNode.next = head;
        head = newNode;
    }

    void print() {
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main (String args[]) {
        Qs_Exercise12_4 llist = new Qs_Exercise12_4();
        llist.push(11);
        llist.push(10);
        llist.push(8);
        llist.push(6);
        llist.push(4);
        llist.push(2);
        llist.push(0);
        System.out.println("Linked List");
        llist.print();

        llist.segregateEvenOdd();
        System.out.println("Update LL");
        llist.print();
    }

}
