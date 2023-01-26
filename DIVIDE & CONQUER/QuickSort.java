public class QuickSort {
    
    public static void printArr(int arr[]) {
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void quickSort(int arr[], int si, int ei) {
        //base case
        if(si >= ei) {
            return;
        }
        // Pivot -> last element
        // Partition on basis of pivot //This partition fxn gives the index of pivot
        int pidx = partition(arr, si, ei); // partition fxn will take pivot, pivot se phele small elements ko le aaye, pivot se aage larger elements ko le aayega, pivot ko bhi shi jagah lake pivot ka sahi index de dega

        // call quickSort
        quickSort(arr, si, pidx-1); //sort the left part
        quickSort(arr, pidx+1, ei); // sort the right part
    }

    public static int partition(int arr[], int si, int ei) {
        int pivot  = arr[ei];
        int i = -1; // to make spcae(place) for elements smaller than pivot

        for(int j = 0; j < ei; j++) { // j run upto the value is less than pivot
            if(arr[j] <= pivot) { // If yes, then make space
                i++;
                // Swap
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        // to place the pivot in the right(correct) place
        i++;
        int temp = pivot;
        arr[ei] = arr[i]; // pivot = arr[i]; we can't write this line because pivot is a variable, mujhe to index pr array ke andar change krna hai
        arr[i] = temp; //we stored pivot in i index
        return i;
    }

    public static void main(String args[]) {
        int arr[] = {6, 3, 9, 8, 2, 5, -5};
        quickSort(arr, 0, arr.length-1);
        printArr(arr);

    }
}