/* You are given an array ‘arr’ of size ‘n’ which denotes the position of stalls.
You are also given an integer ‘k’ which denotes the number of aggressive cows.
You are given the task of assigning stalls to ‘k’ cows such that the minimum distance between any two of them is the maximum possible.
Find the maximum possible minimum distance.*/

import java.util.Arrays;

public class AggresiveCows {
    public static boolean canWePlace(int arr[], int dist, int cows) {
        int n = arr.length;
        int cntCows = 1;
        int last = arr[0]; // pos of last placed cow

        for (int i = 1; i < n; i++) {
            if (arr[i] - last >= dist) {
                cntCows++;
                last = arr[i];
            }

            if (cntCows >= cows) {
                return true;
            }
        }

        return false;
    }

    // TC = O((max-min)*n) ; SC = O(1) ; Brute Force
    public static int cows(int arr[], int k) {
        int n = arr.length;
        Arrays.sort(arr);

        int limit = arr[n - 1] - arr[0];
        for (int i = 1; i <= limit; i++) {
            if (canWePlace(arr, i, k) == false) {
                return (i - 1);
            }
        }

        return limit;
    }

    // Binary Search Approach
    // TC = O(NlogN) + O(N * log(max(stalls[])-min(stalls[]))), N is arr.length; SC = O(1)
    public static int cows2(int arr[], int k) {
        int n = arr.length;
        Arrays.sort(arr);

        int low = 1, high = arr[n - 1] - arr[0];

        // apply binary search
        while (low <= high) {
            int mid = (low + high) / 2;
            if (canWePlace(arr, mid, k) == true) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return high;
    }

    public static void main(String[] args) {
        int[] stalls = { 0, 3, 4, 7, 10, 9 };
        int k = 4;
        int ans = cows(stalls, k);
        int ans2 = cows2(stalls, k);
        System.out.println("The maximum possible minimum distance is: " + ans);
        System.out.println("The maximum possible minimum distance is: " + ans2);
    }
}