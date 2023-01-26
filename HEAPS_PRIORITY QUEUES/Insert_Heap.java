import java.util.ArrayList;

public class Insert_Heap {
    static class Heap {
        ArrayList<Integer> arr = new ArrayList<>();

        public void add(int data) {
            // add at last index
            arr.add(data);

            int x = arr.size()-1; // x is child index
            int par = (x - 1) / 2; // parent index

            while(arr.get(x) < arr.get(par)) { // O(logn)
                // swap
                int temp = arr.get(x);
                arr.set(x, arr.get(par));
                arr.set(par, temp);

                // update child and parent pointers
                x = par;
                par = (x -1) / 2;
            }
        }

        public int peek() {
            return arr.get(0);
        }

        private void heapify(int i) { // fix my heap
            int left = 2*i+1;
            int right = 2*i+2;
            int minIdx = i; // root idx -> we assume in minHeap that or root is min element

            // compare root with left and roght childs

            if(left < arr.size() && arr.get(minIdx) > arr.get(left)) { // left < arr.size() -> this condition is for lesf nodes
                minIdx = left;
            }

            if(right < arr.size() && arr.get(minIdx) > arr.get(right)){
                minIdx = right;
            }

            // to fix means, if our root is not min
            if(minIdx != i) {
                // swap 
                int temp = arr.get(i);
                arr.set(i, arr.get(minIdx));
                arr.set(minIdx, temp);

                // we fix this upper node, but what if because of that my lower node may got disrupts
                heapify(minIdx);
            }
        }

        public int remove() {
            int data = arr.get(0);

            // Step -1 - swap first and last
            int temp = arr.get(0);
            arr.set(0, arr.get(arr.size()-1));
            arr.set(arr.size()-1, temp);

            // Step -2 - delete last
            arr.remove(arr.size()-1);

            // Step -3 - heapify
            heapify(0);
            return data;
        }

        public boolean isEmpty() {
            return arr.size() == 0;
        }
    }

    public static void main(String args[]) {
        Heap h = new Heap();
        h.add(3);
        h.add(4);
        h.add(1);
        h.add(5);

        while(! h.isEmpty()) {
            System.out.println(h.peek());
            h.remove();
        }
    }
}
