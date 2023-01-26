// Check if a given array is Sorted or not

public class Problem6 {

    public static boolean isSorted(int arr[], int i) { //i is starting point 
        //Base case
        if(i == arr.length-1){
            return true;
        }

        if (arr[i] > arr[i+1]){
            return false;
        } //but is above this is true, then we will see that the after remaining array is sorted or not

        return isSorted(arr, i+1);
    }
    public static void main (String args[]) {
        int arr[] = {1, 2, 3, 4, 5};
        System.out.println(isSorted(arr, 0)); //we want ro start comparing from 0th 
    }
}
