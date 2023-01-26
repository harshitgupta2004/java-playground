public class LinkedList {

    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    public static Node head;
    public static Node tail;
    public static int size; // by default, initizalized value = 0

    // Methods


    // Add:
    // Add first
    public void addFirst (int data) {
        // Step - 1: Create new node
        Node newNode = new Node(data);
        size++;
        if(head == null) {
            head = tail = newNode;
            return;
        }

        // Step - 2: newNode next = head
        newNode.next = head; // Link // next ke andar iss head ka refernce store ho gya hai

        // Step - 3: head = newNode
        head = newNode;
    }
    // Add last
    public void addLast (int data) {
        Node newNode = new Node(data);
        size++;
        if(head == null){
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }


    // Print a LL:
    public void print() {
        if(head == null) {
            System.out.println("LL is empty");
            return;
        }
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.data+ " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }


    // Add in the middle
    public void add(int idx, int data) {
        if(idx == 0) {
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        size++;
        Node temp = head;
        int i = 0;

        while(i < idx-1){
            temp = temp.next;
            i++;
        }

        // i = idx - 1; temp -> previous
        newNode.next = temp.next;
        temp.next = newNode;
    }


    // Remove:

    // Remove First
    public int removeFirst() {
        // special case
        if(size == 0) {
            System.out.println("LL is empty");
            return Integer.MIN_VALUE; // we don't return here a valid value
        } else if(size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }

        int val = head.data; //The value which we gonna remove is data of head
        head = head.next;
        size--;
        return val;
    } 

    // Remove Last
    public int removeLast() {
        if(size == 0) {
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        } else if(size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }

        // Use loop to reach prev node -> i = size - 2;
        Node prev = head;
        for(int i = 0; i < size-2; i++) {
            prev = prev.next;
        }

        int val = prev.next.data; // prev.next.data means tail.data
        prev.next = null;
        tail = prev;
        size--;
        return val;
    }


    // Search (Iterative) -> O(n)
    public int iterativeSearch(int key) {
        Node temp = head;
        int i = 0;

        while (temp != null) {
            if(temp.data == key) { //key found
                return i;
            }
            temp = temp.next;
            i++;
        }

        // key not found
        return -1;
    }

    // Search Recursive -> O(n) of helper fxn
    // it is a helper fxn used to change the head everytime
    public int helper(Node head, int key) { // O(n)
        // Base case
        if(head == null) {
            return -1;
        }

        if(head.data == key) {
            return 0;
        }

        // Track that helper fxn able to find the key in the remaining LL , in the head.next
        int idx = helper(head.next, key);
        // if not able to find
        if(idx == -1) {
            return -1;
        }

        return idx+1; // if it find it
    }
    public int recursiveSearch(int key) {
        return helper(head, key);
    }


    // Reverse a LL -> O(n)
    public void reverse() {
        Node prev = null; // starting with before head node which is obviously empty
        Node curr = tail = head;
        Node next;

        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }


    // Find and Remove Nth node from end
    public void deleteNthfromEnd(int n) {
        // calculating size itself
        int sz = 0;
        Node temp = head;
        while(temp != null){
            temp = temp.next;
            sz++;
        }

        if(n == sz) {
            head = head.next; // removeFirst operation
            return;
        }

        // sz-m
        int i = 1;
        int iToFind = sz-n;
        Node prev = head;
        while(i < iToFind) {
            prev = prev.next;
            i++;
        }

        prev.next = prev.next.next;  
        return;
    }


    // LL is Palindrome or not

    // Slow - Fast Approach
    public Node findMid(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next; //+1
            fast = fast.next.next; //+2
        } 

        return slow; // slow is my middle
    }
    
    public boolean isPalindrome() {
        // base case
        if(head == null || head.next == null) {
            return true;
        }

        // Step - 1: find mid
        Node midNode = findMid(head);
        
        // Step - 2: reverse 2nd half
        Node prev = null;
        Node curr = midNode;
        Node next;
        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Node right = prev; //Right half head
        Node left = head;

        // Step - 3: check if left half and right half equal
        while(right != null) {
            if(left.data != right.data) {
                return false;
            }
            left = left.next;
            right = right.next;
        }

        return true;
    }



    // MERGE SORT
    private Node getMid(Node head) {
        Node slow = head;
        Node fast = head.next;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow; // mid node
    }

    private Node merge(Node head1, Node head2) {
        Node mergedLL = new Node(-1);
        Node temp = mergedLL;

        while(head1 != null && head2 != null) {
            if(head1.data <= head2.data) {
                temp.next = head1;
                head1 = head1.next;
                temp = temp.next;
            } else {
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;
            }
        }

        while(head1 != null) {
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }

        while(head2 != null) {
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }

        return mergedLL.next;
    }

    public Node mergeSort(Node head) {

        // Base case
        if(head == null || head.next == null) {
            return head;
        }
        // Find mid
        Node mid = getMid(head);

        // left and right mergeSort
        Node rightHead = mid.next;
        mid.next = null;
        Node newLeft = mergeSort(head); //sorted left ha;f
        Node newRight = mergeSort(rightHead); //sorted right half

        // Merge
        return merge(newLeft, newRight);
    }

    public static void main(String args[]) {

        // Creating a Linked List
        LinkedList ll = new LinkedList();
        // ll.head = new Node(1);
        // ll.head.next = new Node(2);
        // Printing the whole LL one by one
        ll.print();

        // For adding elements
        ll.addFirst(2);
        // Print
        ll.print();

        ll.addFirst(1);
        ll.print();
        
        ll.addLast(3);
        ll.print();
        
        ll.addLast(4);
        ll.print();

        // Add in the middle
        ll.add(2, 9);
        ll.print();

        // Size of LL
        System.out.println(ll.size);

        // Remove First
        ll.removeFirst();
        ll.print();

        // Remove Last;
        ll.removeLast();
        ll.print();

        // Search
        System.out.println(ll.iterativeSearch(3));
        System.out.println(ll.iterativeSearch(10));

        System.out.println(ll.recursiveSearch(3));
        System.out.println(ll.recursiveSearch(10));

        // Reverse
        ll.reverse();
        ll.print();
        
        // Nth from End
        ll.deleteNthfromEnd(3);
        ll.print();

        // Palindrome
        System.out.println(ll.isPalindrome());


        // MAERGE SORT
        //LinkedList ll = new LinkedList();
        ll.addFirst(1);
        ll.addFirst(2);
        ll.addFirst(3);
        ll.addFirst(4);
        ll.addFirst(5);

        ll.print();
        ll.head = ll.mergeSort(head);
        ll.print();
    }
}