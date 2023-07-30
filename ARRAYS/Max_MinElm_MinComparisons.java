import java.util.Arrays;
import java.util.Scanner;

public class Max_MinElm_MinComparisons {

    // Approach 1 : sort the array and 1st elm is min and last elm is max

    public static int mini(int arr[], int n){
        Arrays.sort(arr);
        int min = arr[0];
        return min;
    }

    public static int maxi(int arr[], int n){
        Arrays.sort(arr);
        int max = arr[n-1];
        return max;
    }

    /* Approach 2 : Pairs 
    If n is odd then initialize min and max as the first element. 
    If n is even then initialize min and max as minimum and maximum of the first two elements respectively. 
    For the rest of the elements, pick them in pairs and compare their 
    maximum and minimum with max and min respectively */

    static class Pair{
        int min;
        int max;
    }

    public static Pair getminmax(int arr[], int n){
        Pair mixmax = new Pair();
        int i;

        if(n%2 == 0){ // even
            if(arr[0] < arr[1]){
                mixmax.min = arr[0];
                mixmax.max = arr[1];
            }else{
                mixmax.min = arr[1];
                mixmax.max = arr[0];
            }
            i = 2;
        }
        else{ // odd
            mixmax.min = arr[0];
            mixmax.max = arr[0];
            i = 1;
        }

        while(i < n-1){
            if(arr[i] > arr[i+1]){
                if(arr[i] > mixmax.max){
                    mixmax.max = arr[i];
                }
                if(arr[i+1] < mixmax.min){
                    mixmax.min = arr[i+1];
                }
            }
            else{
                if(arr[i+1] > mixmax.max){
                    mixmax.max = arr[i+1];
                }
                if(arr[i] < mixmax.min){
                    mixmax.min = arr[i];
                }
            }

            i += 2; // Increment the index by 2 as two elements are processed in loop 
        }

        return mixmax;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }   
        
        // System.out.println(mini(arr, n));
        // System.out.println(maxi(arr, n));

        Pair minmax = getminmax(arr, n);
        System.out.println(minmax.min);
        System.out.println(minmax.max);
    }
}
