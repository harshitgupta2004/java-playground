import java.util.*;

public class HeapSort {

    public static void heapify(int arr[], int i, int size) {
        int left = 2*i+1;
        int right = 2*i+2;
        int maxIdx = i;

        if(left < size && arr[left] > arr[maxIdx]) {
            maxIdx = left;
        }

        if(right < size && arr[right] > arr[maxIdx]) {
            maxIdx = right;
        }

        if(maxIdx != i){
            // swap 
            int temp = arr[i];
            arr[i] = arr[maxIdx];
            arr[maxIdx] = temp;

            heapify(arr, maxIdx, size);
        }
    }

    public static void heapSort(int arr[]) {
        // Step -1 - build maxHeap 
        int n = arr.length;
        for(int i = n/2; i >= 0; i--) { // call heapify for all nodes except those at last level
            heapify(arr, i, n); // which index you are calling for heapify, and heap size -> because in step 2 we have to tell how much size of heap is left 
        }

        // Step -2 - Push largest at end
        for(int i = n-1; i > 0; i--){
            // swap (largest-first with last)
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, 0, i); // heap size decreased by 1 as size of i (idx) dec by 1
        }
    }
    public static void main(String args[]) {
        int arr[] = {1, 2, 4, 5, 3};
        heapSort(arr);

        // print
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] +" ");
        }
        System.out.println();
    }
}
