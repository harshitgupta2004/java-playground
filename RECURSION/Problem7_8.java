public class Problem7_8 {

    //Write a fxn to find the FIRST OCCURENCE of an elemet in an array 
    public static int firstOccurence(int arr[], int key, int i) {
        // base case
        if(i == arr.length) {
            return -1;
        }
        if(arr[i] == key) {
            return i;
        }

        // if not found at i then, call fxn
        return firstOccurence(arr, key, i+1);
    }


    //Write a fxn to find the LAST OCCURENCE of an elemet in an array
    public static int lastOccurence(int arr[], int key, int i) {
        // base case
        if (i == arr.length) {
            return -1;
        }
        int isFound = lastOccurence(arr, key, i+1); //firstly, look forward that is there even any key exists afterwards or not (for last occurence); and if not, then, -1 aa jayega
        if(isFound == -1 && arr[i] == key) { //means a valid index return
            return i;
        }        
        
        //Check with self -> if the above condition isFound is false
        // if(arr[i] == key) {
        //     return i;
        // }

        return isFound;
    }


    public static void main(String args[]) {
        int arr[] = {8, 3, 6, 9, 5, 10, 2, 5, 3};
        System.out.println(firstOccurence(arr, 5, 0));
        System.out.println(lastOccurence(arr, 5, 0));
    }
}
