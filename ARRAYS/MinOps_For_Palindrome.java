public class MinOps_For_Palindrome {
    public static int minOps(int arr[], int n){
        int ans = 0;
        // start from two corners
        for(int i = 0, j = n-1; i <= j;){

            // If corner elements are same, problem reduces arr[i+1..j-1]
            if(arr[i] == arr[j]){
                i++;
                j--;
            }

            // If left element is greater, then we merge right two elements
            else if(arr[i] > arr[j]){
                // need to merge from tail
                j--;
                arr[j] += arr[j+1];
                ans++;
            }

            // Else we merge left two elements
            else{
                i++;
                arr[i] += arr[i-1];
                ans++;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int arr[] = {1, 4, 5, 9, 1} ;
        int n = arr.length;
        System.out.println(minOps(arr, n));
    }
}