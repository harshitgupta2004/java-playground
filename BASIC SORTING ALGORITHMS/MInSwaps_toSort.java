// Given an array of N distinct elements, find the minimum number of swaps required to sort the array.
// TC = O(n*logn); SC = O(n)

import java.util.*;

public class MInSwaps_toSort {
    public static int minSwaps(int arr[], int n) {
        int ans = 0;
        int temp[] = Arrays.copyOfRange(arr, 0, n);

        // Hashmap which stores the indexes of the input array
        HashMap<Integer, Integer> m = new HashMap<Integer, Integer>();

        Arrays.sort(temp);
        for (int i = 0; i < n; i++) {
            m.put(arr[i], i);
        }

        for (int i = 0; i < n; i++) {
            // This is checking whether the current element is at the right place or not
            if (arr[i] != temp[i]) {
                ans++;
                int init = arr[i];

                // If not, swap this element with the index of the element which should come
                // here
                swap(arr, i, m.get(temp[i]));

                // Update the indexes in the hashmap accordingly
                m.put(init, m.get(temp[i]));
                m.put(temp[i], i);
            }
        }

        return ans;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] a = { 101, 758, 315, 730, 472, 619, 460, 479 };
        int n = a.length;

        System.out.println(minSwaps(a, n));
    }
}
