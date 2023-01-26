// Split the given array into K sub-arrays
// We have an Array[] of N elements and a number K. (1<=K<=N). Split the given array into K subarrays (they must cover all the elements). 
// The maximum subarray sum achievable out of K subarrays formed must be the minimum possible. Find that possible subarray sum.

// TC = ((N-1)c(K-1))
// ‘c’ here depicts combinations i.e. ((n-1)!/((n-k)!*(k-1)!) Where N is the number of elements of the array and K is the number of divisions that we are having

// SC = O(n)

import java.util.*;

public class SplitArray {

    public static int ans = 10000000;
    public static void solve(int a[], int n, int k, int index, int sum, int maxSum) {
        if(k == 1) {
            maxSum = Math.max(maxSum, sum);
            sum = 0;
            for(int i = index; i < n; i++) {
                sum += a[i];
            }
            maxSum = Math.max(maxSum, sum);
            ans = Math.min(ans, maxSum);
            return;
        }

        sum = 0;
        for(int i = index; i < n; i++) {
            sum += a[i];
            maxSum = Math.max(maxSum, sum);
            solve(a, n, k-1, i+1, sum, maxSum);
        }
    }
    public static void main(String args[]) {
        int arr[] = {1, 2, 3, 4};
        int k = 3; // k divisions
        int n = 4; // size of array
        solve(arr, n, k, 0, 0, 0);
        System.out.println(ans);
    }
}
