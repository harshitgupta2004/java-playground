public class RepeatingAndMissing {
    public static void missrep(int arr[], int n){
        // repeating
        for(int i = 0; i < n; i++){
            int absVal = Math.abs(arr[i]);
            if(arr[absVal - 1] > 0){
                arr[absVal - 1] = -arr[absVal-1];
            }
            else{
                System.out.println(absVal);
            }
        }

        // missing : traverse the array again and look for a positive value.
        for(int i = 0; i < n; i++){
            if(arr[i] > 0){
                System.out.println(i+1);
            }
        }
    }
    public static void main(String[] args) {
        int arr[] = { 7, 3, 4, 5, 5, 6, 2 };
        int n = arr.length;
        missrep(arr, n);
    }
}
