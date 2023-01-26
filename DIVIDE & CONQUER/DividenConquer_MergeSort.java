public class DividenConquer_MergeSort {

    public static void printArr(int arr[]) {
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // MERGE SORT
    public static void mergeSort(int arr[], int si, int ei) {
        // base case
        if(si >= ei) {
            return;
        }
        
        //kaam
        int mid = si + (ei - si) / 2; //or we can use (si+ei)/2
        mergeSort(arr, si, mid); //left part became sorted
        mergeSort(arr, mid+1, ei); //right part became sorted
        // merge the two parts
        merge(arr, si, mid, ei);
    }

    public static void merge(int arr[], int si, int mid, int ei) {
        // Firstly, make a temp array to merge the left and right part
        int temp[] = new int[ei-si+1]; //assume left(0,3)= 4 elements and right(4,6)=3 elements; so temp will require 4+3=7 space -> 6-0+1 -> ei-si+1
        int i = si; // iterator for left part
        int j = mid+1; // iterator for right part
        int k = 0; // iterator for temp arr

        while(i <= mid && j <= ei) {
            if(arr[i] < arr[j]) { // left part element < right part element 
                temp[k] = arr[i];
                i++; //the above i uses, so movo on to next index
            } else{
                temp[k] = arr[j]; // put right part element into temp arr
                j++;
            }
            k++;
        }

        // for left part(something left in left part) for leftover elemnts (like- all left elements are sorted put in temp, but some elements of roght part are still remaining)
        while(i <= mid) {
            temp[k++] = arr[i++]; // k ki cuurent value ko le lega and usko increment kr dega; same with i
        }

        // for right part
        while(j <= ei) {
            temp[k++] = arr[j++];
        }

        // Copy temp to original array
        for(k = 0, i = si; k < temp.length; k++, i++) {
            arr[i] = temp[k];
        }
    }

    public static void main(String args[]) {
        int arr[] = {6, 3, 9, 5, 2, 8, -1} ;
        mergeSort(arr, 0, arr.length-1);
        printArr(arr);
    }
}