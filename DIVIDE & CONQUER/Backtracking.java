public class Backtracking {

    public static void changeArr(int arr[], int i, int val) { // We need an index to traverse thorugh array that which index value we have to change now; and change the value to what. 
        // val -> that value which we gonna assign in that index i

        // Base Case
        if(i == arr.length) {
            printArr(arr);
            return;
        }

        // Recusrion (our work)
        arr[i] = val; // value will store at ith value
        changeArr(arr, i+1, val+1); // fxn call step
        arr[i] = arr[i] - 2; // Backtracking Step // When the call returns, from every value -2 occurs
    }

    public static void printArr(int arr[]) {
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public static void main(String args[]) {
        int arr[] = new int[5]; //We make an empty array; In this, the values will be assigned ny my recursive function
        changeArr(arr, 0, 1);
        printArr(arr);
    }
}