// Given an array of integers. Find the Inversion Count in the array
// Inversion Count: For an array, inversion count indicates how far (or close) the array is from being sorted. If the array is already sorted then the inversion count is 0. 
// If an array is sorted in the reverse order then the inversion count is the maximum.
// Formally, two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j.

// Approach 1 - BRUTE FORCE; TC = O(n^2)

// public class Qs_Exercise10_3 {

//     public static int getInvCount(int arr[]) {
//         int n = arr.length;
//         int invCount = 0;

//         for(int i = 0; i < n-1; i++) {
//             for(int j = i + 1; j < n; j++) {
//                 if(arr[i] > arr[j]) {
//                     invCount++;
//                 }
//             }
//         }
//         return invCount;
//     }

//     public static void main(String args[]) {
//         int arr[] = {1, 20, 6, 4, 5};
//         System.out.println("Inversion Count = " + getInvCount(arr));
//     }
// }



// Approach 2 - Modified Merge Sort; TC = O(n*logn)

public class Qs_Exercise10_3 {

    public static int merge(int arr[], int left, int mid, int right) {
        int i = left, j = mid, k = 0;
        int invCount = 0;
        int temp[] = new int[(right - left + 1)];

        while((i < mid) && (j <= right)) {
            if(arr[i] <= arr[j]) {
                temp[k] = arr[i];
                k++;
                i++;
            }
            else {
                temp[k] = arr[j];
                invCount += (mid - i);
                k++;
                j++;
            }
        }

        while(i < mid) {
            temp[k] = arr[i];
            k++;
            i++;
        }

        while(j <= right) {
            temp[k] = arr[j];
            k++;
            j++;
        }

        for(i = left, k = 0; i <= right; i++, k++) {
            arr[i] = temp[k];
        }

        return invCount;
    }

    public static int mergeSort(int arr[], int left, int right) {
        int invCount = 0;

        if(right > left) {
            int mid = (right + left) / 2;

            invCount = mergeSort(arr, left, mid);
            invCount += mergeSort(arr, mid+1, right);
            invCount += merge(arr, left, mid+1, right);
        }
        return invCount;
    }

    public static int getInversion(int arr[]) {
        int n = arr.length;
        return mergeSort(arr, 0, n-1);
    }

    public static void main(String args[]) {
        int arr[] = {1, 20, 6, 4, 5};
        System.out.println("Inversion Count = " + getInversion(arr));
    }
}