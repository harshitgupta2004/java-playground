public class Queues {

    static class Queue {
        static int arr[];
        static int size;
        static int rear;

        Queue(int n) {
            arr = new int[n];
            size = n;
            rear = -1;
        }

        // isEmpty fxn
        public static boolean isEmpty() {
            return rear == -1; // Reae val is -1 when initialized, if its still -1, then that means Queue is empty, no element got sotred in the queue
        }

        // Add
        public static void add(int data) {
            if(rear == size-1) {
                System.out.println("Queue is full");
                return;
            }

            rear = rear+1;
            arr[rear] = data;
        }

        // Remove
        public static int remove() {
            if(isEmpty()) {
                System.out.println("Empty Queue");
                return -1; // return @, $, any special char in cases of char instead of int arr
            }

            int front = arr[0];
            for(int i = 0; i < rear; i++) {
                arr[i] = arr[i+1]; // to remove, shift all elements by 1 backwards(-1)
            }

            rear = rear - 1;
            return front;
        }

        // Peek
        public static int peek() {
            if(isEmpty()) {
                System.out.println("Empty Queue");
                return -1;
            }

            return arr[0]; // front
        }
    }
    public static void main(String args[]) {
        Queue q = new Queue(5);
        q.add(1);
        q.add(2);
        q.add(3);

        while(! q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();
        }
    }
}