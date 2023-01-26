public class SearchRotatedSortedArray {

    public static int serach(int arr[], int tar, int si, int ei) {
        // Base case
        if(si > ei) {
            return -1; // invalid condition -> target does not exist in our array
        }

        //kaam
        int mid = si + (ei-si) / 2; // or use (si+ei)/2

        // Case Found
        if(arr[mid] == tar) { //target at mid
            return mid;
        }

        // Mid on L1
        if(arr[si] <= arr[mid]) {
            // Case a : Left
            if(arr[si] <= tar && tar <= arr[mid]) {
                return serach(arr, tar, si, mid-1); //mid-1 because we already search that if mid the tar val in line 9
            } else {
                // Case b : Right
                return serach(arr, tar, mid+1, ei);
            }
        }

        // Mid on L2
        else {
            // Case c : Right
            if(arr[mid] <= tar && tar <= arr[ei]) {
                return serach(arr, tar, mid+1, ei);
            } else {
                // Case d : Left
                return serach(arr, tar, si, mid-1);
            }
        }
    }

    public static void main(String args[]) {
        int arr[] = {4, 5, 6, 7, 0, 1, 2};
        int target = 0; //o/p -> 4
        int tarIdx = serach(arr, target, 0, arr.length-1);
        System.out.println(tarIdx);        
    }
}