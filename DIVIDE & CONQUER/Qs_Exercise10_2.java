// Given an array nums of size n, return the majority element
// The majority element is the element that appears more than [n / 2] times. Assume that the majority element always exists in the array.


// Approach 1 - BRUTE FORCE; TC = O(n^2)
// Idea : Count the number of times each number occurs in the array & find the largest count

// public class Qs_Exercise10_2 {

//     public static int majorityElement(int nums[]) {
//         int majorityCount = nums.length/2;
//         for(int i = 0; i < nums.length; i++) {
//             int count = 0;
//             for(int j = 0; j < nums.length; j++) {
//                 if(nums[j] == nums[i]) {
//                     count += 1;
//                 }
//             }
//             if(count > majorityCount) {
//                 return nums[i];
//             }
//         }
//         return -1;
//     }

//     public static void main(String args[]) {
//         int nums[] = {2,2,1,1,1,2,2};
//         System.out.println(majorityElement(nums));
//     }
// }


// Approach 2 - DIVIDE & CONQUER; TC = O(n*logn)
// Idea : If we know the majority element in the left and right halves of an array, we can determine which is the global majority element in linear time

public class Qs_Exercise10_2 {

    public static int countInRange(int nums[], int num, int lo, int hi) {
        int count = 0;
        for(int i = lo; i <= hi; i++) {
            if(nums[i] == num) {
                count++;
            }
        }
        return count;
    }

    public static int majorityElementRec(int nums[], int lo, int hi) {
        // base case; the only element in an array of size 1 is the majority element
        if(lo == hi) {
            return nums[lo];
        }

        // Recusrse on Left and Right halves of this slice
        int mid = (hi-lo) / 2 + lo;
        int left = majorityElementRec(nums, lo, mid);
        int right = majorityElementRec(nums, mid+1, hi);

        // If the two halves agree on the majority elements, return it
        if(left == right) {
            return left;
        }

        // Otherwise, count each element and return the "winner"
        int leftCount = countInRange(nums, left, lo, hi);
        int rightCount = countInRange(nums, right, lo, hi);

        return leftCount > rightCount ? left : right;
    }

    public static int majorityElement(int nums[]) {
        return majorityElementRec(nums, 0, nums.length-1);
    }

    public static void main(String args[]) {
        int nums[] = {2,2,1,1,1,2,2};
        System.out.println(majorityElement(nums));
    }
}