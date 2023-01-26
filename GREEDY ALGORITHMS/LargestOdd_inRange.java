// Kth largest odd number in a given range
// We have two variables L and R, indicating a range of integers from L to R inclusive, and a number K, the task is to find Kth largest odd number. 
// If K > number of odd numbers in the range L to R then return 0

// TC = SC = O(1)

import java.util.*;

public class LargestOdd_inRange {

    public static int kthOdd(int range[], int k) {
        if(k <= 0) {
            return 0;
        }

        int L = range[0];
        int R = range[1];

        if((R & 1) > 0) {
            int count = (int) Math.ceil((R-L+1)/2);
            if(k > count) {
                return 0;
            } else {
                return (R-2*k+2);
            }
        } else {
            int count = (R-L+1)/2;
            if(k > count) {
                return 0;
            } else {
                return (R-2*k+1);
            }
        }
    }
    public static void main(String args[]) {
        int p[] = {-3, 3};
        int k = 1;
        System.out.println(kthOdd(p, k));
    }
}
