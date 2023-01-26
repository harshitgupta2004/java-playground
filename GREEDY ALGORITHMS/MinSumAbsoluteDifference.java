import java.util.*;

public class MinSumAbsoluteDifference {
    public static void main(String args[]) {
        int A[] = {4, 1, 8, 7};
        int B[] = {2, 3, 6, 5};

        // sort 
        Arrays.sort(A);
        Arrays.sort(B);

        int minDiff = 0;
        
        for(int i = 0; i < A.length; i++) {
            minDiff += Math.abs(A[i]-B[i]);
        }

        System.out.println("Min Absolute Difference of pairs = " + minDiff);
    }
}