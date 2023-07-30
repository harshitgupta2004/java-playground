public class CombinationOf_r_Elements {

    // index : Current index in data[]
    // r : Size of a combination to be printed
    // i : index of arr
    public static void combUtil(int arr[], int n, int r, int data[], int index, int i){
        
        // Current comb is ready to print
        if(index == r){
            for(int j = 0; j < r; j++){
                System.out.print(data[j] + " ");
            }
            System.out.println();
            return;
        }

        // when no more elms are there to put in data[]
        if(i >= n){
            return;
        }

        // choice : to include current and call for next idx in both data[] and arr
        data[index] = arr[i];
        combUtil(arr, n, r, data, index+1, i+1);

        // to exclude current and call for next idx in arr only , same idx for data[] as we don't put the eml there 
        combUtil(arr, n, r, data, index, i+1);
    }

    public static void comb(int arr[], int n, int r){
        int data[] = new int[r];
        combUtil(arr, n, r, data, 0, 0);
    }
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5};
        int n = arr.length;
        int r = 3;
        comb(arr, n, r);
    }    
}
