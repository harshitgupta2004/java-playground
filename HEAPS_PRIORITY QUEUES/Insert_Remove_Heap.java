// This is for MinHeap -> we can change some logic here to change it into Max Heap (16, 35, 39, 43 lines change)

import java.util.ArrayList;

public class Insert_Remove_Heap {
    static class Heap {
        ArrayList<Integer> arr = new ArrayList<>();

        public void add(int data) {
            // add at last index
            arr.add(data);

            int x = arr.size()-1; // x is child index
            int par = (x - 1) / 2; // parent index

            while(arr.get(x) < arr.get(par)) { // now if we want to change this into max Heap, just change here < to '>'
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
            int minIdx = i; // root idx -> we assume in minHeap that or root is min element // change it into MaxHeap by changing name into maxIdx

            // compare root with left and roght childs

            if(left < arr.size() && arr.get(minIdx) > arr.get(left)) { // left < arr.size() -> this condition is for lesf nodes
                minIdx = left; // // to change into MaxHeap -> change the '>' in (arr.get(minIdx) > arr.get(left)) to '<'
            }

            if(right < arr.size() && arr.get(minIdx) > arr.get(right)){ // to change into MaxHeap -> change the '>' in (arr.get(minIdx) > arr.get(right)) to '<'
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
        Heap pq = new Heap(); // PQ implemented in the form of heap ds -> all fxns and o/p are same as in PQ we did using JCF earlier
        pq.add(3);
        pq.add(4);
        pq.add(1);
        pq.add(5);

        while(! pq.isEmpty()) { // heap sort
            System.out.println(pq.peek());
            pq.remove();
        }
    }
}
