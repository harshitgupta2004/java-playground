public class CircularQueue {
    
    static class Queue {
        static int arr[];
        static int size;
        static int rear;
        static int front;

        Queue(int n) {
            arr = new int[n];
            size = n;
            rear = -1;
            front = -1;
        }

        // isEmpty fxn
        public static boolean isEmpty() {
            return rear == -1 && front == -1;
        }

        public static boolean isFull() {
            return (rear + 1) % size == front;
        }

        // Add
        public static void add(int data) {
            if(isFull()) {
                System.out.println("Queue is full");
                return;
            }

            // When we are adding for the 1st time - add 1st element
            if(front == -1) {
                front = 0;
            }
            rear = (rear+1) % size;
            arr[rear] = data;
        }

        // Remove
        public static int remove() {
            if(isEmpty()) {
                System.out.println("Empty Queue");
                return -1; // return @, $, any special char in cases of char instead of int arr
            }

            int result = arr[front];
            
            // special case : when delete remove last element (only 1 elemnt remaining), so we have to make them -1 as queue becomes empty
            if(rear == front) {
                rear = front = -1;
            } else {
                front = (front + 1) % size;
            }
            return result;
        }

        // Peek
        public static int peek() {
            if(isEmpty()) {
                System.out.println("Empty Queue");
                return -1;
            }

            return arr[front]; // front
        }
    }
    public static void main(String args[]) {
        Queue q = new Queue(3);
        q.add(1);
        q.add(2);
        q.add(3);
        System.out.println(q.remove());
        q.add(4);
        System.out.println(q.remove());
        q.add(5);

        while(! q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();
        }


    }
}
