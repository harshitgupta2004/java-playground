// O(n); SC = O(1)
public class Pair_GivenSum {
    public static boolean findPair(int arr[], int k){
        int n = arr.length;
        
        //find the pivot 
        int pivot = 0;
        for(int i = 0; i < n-1; i++){
            if(arr[i] > arr[i+1]){
                pivot = i+1;
            }
        }

        int l = pivot;
        int r = pivot-1;
        while(l != r){
            if(arr[l] + arr[r] == k){
                return true;
            }
            else if(arr[l] + arr[r] < k){
                l = (l+1)%n;
            }
            else{
                r = (r-1+n)%n;
            }
        }

        return false;
    }
    public static void main(String[] args) {
        int[] arr = {11, 15, 6, 8, 9, 10};
        int k = 16;
        System.out.println(findPair(arr, k));
    }
}
