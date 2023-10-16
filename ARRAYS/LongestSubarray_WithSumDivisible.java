import java.util.HashMap;

public class LongestSubarray_WithSumDivisible {

    public static int longest(int arr[], int n, int k){
        int maxL = 0;
        for(int i = 0; i < n; i++){
            int sum = 0;
            for(int j = i; j < n; j++){
                sum += arr[j];
                if(sum % k == 0){
                    maxL = Math.max(maxL, j-i+1);
                }
            }
        }

        return maxL;
    }

    public static int approach(int arr[], int n, int k){
        HashMap<Integer, Integer> h = new HashMap<>();
        h.put(0, -1);
        int maxLen = 0;
        int sum = 0;
        int rem = 0;

        for(int i = 0; i < n; i ++){
            sum += arr[i];
            rem = sum % k;

            if(rem < 0){
                rem += k;
            }

            if(h.containsKey(rem)){
                int len = i - h.get(rem);
                maxLen = Math.max(len, maxLen);
            } else{
                h.put(rem, i);
            }
        }

        return maxLen;
    }
    public static void main(String[] args) {
        int arr[] = {2, 7, 6, 1, 4, 5};
        int k = 3;
        int n = arr.length;
        System.out.println(approach(arr, n, k));
    }
}
