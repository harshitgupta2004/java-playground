//return true if any value appears at least twice in the
//array, and return false if every element is distinct

// public class Qs_Exercise4 {

//     public static boolean appearTwice(int nums[]){
//         for (int i = 0; i < nums.length-1; i++){
//             for (int j = i + 1; j < nums.length; j++){
//                 if (nums[i] == nums[j]){
//                     return true;
//                 }
//             }
//         }
//         return false;
//     }
//     public static void main(String args[]){
//         int nums[] = {1,1,1,3,3,4,3,2,4,2};
//         System.out.println(appearTwice(nums));
//     }
// }


// Question 2 - Array - Sheet
// Approach - Binary Search
// public class Qs_Exercise4 {

//     public static int search (int nums[], int target){
//         // min will have index of min element of nums
//         int min = minSearch(nums);

//         //find in sorted left
//         if (nums[min] <= target && target <= nums[nums.length-1]) {
//             return search(nums, min, nums.length, target);
//         }
//         //find in  sorted right
//         else{
//             return search(nums, 0, min, target);
//         }
//     }

//     //binary search to find target in left to right boundary
//     public static int search(int nums[], int left, int right, int target) {
//         int l = left;
//         int r = right;
        
//         while(l <= r){
//             int mid = l + (r - 1) / 2;
//             if (nums[mid] == target){
//                 return mid;
//             }
//             else if (nums[mid] > target){
//                 r = mid-1;
//             }
//             else{
//                 l = mid + 1;
//             }
//         }
//         return -1;
//     }
    
//     //smallest element index
//     public static int minSearch(int nums[]){
//         int left = 0;
//         int right = nums.length-1;

//         while (left < right){
//             int mid = left + (right - left) / 2;
//             if(mid > 0 && nums[mid-1] > nums[mid]){
//                 return mid;
//             }
//             else if (nums[left] <= nums[mid] && nums[mid] > nums[right]){
//                 left = mid+1;
//             }
//             else{
//                 right = mid-1;
//             }
//         }
//         return left;
//     }
//     public static void main(String args[]){
//         int nums[] = {4,5,6,7,0,1,2};
//         int target = 3;
//         System.out.println(search(nums, target));
//     }
// }


// You are given an array prices where prices[i] 
//is the price of a given stock on the ith day.
//Return the maximum profit you can achieve from this transaction.
//If you cannot achieve any profit, return 0
public class Qs_Exercise4 {

    public static int buyAndSellStocks(int prices[]){
        int buyPrice = Integer.MAX_VALUE;
        int maxProfit = 0; 

        for (int i = 0; i < prices.length; i++){
            if (buyPrice < prices[i]) { // profit - prices[i] means selling price or current aaj ka price
                int profit = prices[i] - buyPrice; //today's profit
                maxProfit = Math.max(maxProfit, profit); // total days ka milake jo bhi max profit aayega vo ye hai
            } else {
                buyPrice = prices[i]; // buyprice ko update krke kr dunga current price ke equal
            }
        }

        return maxProfit;
    }

     public static void main(String args[]){
        int prices[] = {7,6,4,3,1};
        System.out.println(buyAndSellStocks(prices));
    }
}


//Given n non-negative integers representing an elevation map where the width of
//each bar is 1, compute how much water it can trap after raining
// public class Qs_Exercise4 {

//     public static int trappedRainwater(int height[]) {
        
//         int n = height.length;

//         // calculate left max boundary - array - axuilary
//         int leftMax[] = new int [n];
//         leftMax[0] = height[0];
//         for (int i = 1; i < n; i++){
//             leftMax[i] = Math.max(height[i], leftMax[i-1]); //compare current ht with left max of i-1
//         }

//         // calculate roght max boundary - axuilary array
//         int rightMax[] = new int [n];
//         rightMax[n-1] = height[n-1];
//         for (int i = n-2; i >= 0; i--){
//             rightMax[i] = Math.max(height[i], rightMax[i+1]);
//         } 

//         int trappedWater = 0;
//         // loop
//         for (int i = 0; i < n; i++){
//             // waterLevel = min (leftmax bound, rightmax bound)
//             int waterLevel = Math.min(leftMax[i], rightMax[i]);
            
//             // trapped water = waterLevel - height[i]
//             trappedWater += waterLevel - height[i];
//         }

//         return trappedWater;
//     }
//     public static void main(String args[]){
//         int height[] = {0,1,0,2,1,0,1,3,2,1,2,1};
//         System.out.println(trappedRainwater(height));
//     }
// }



//Given an integer array nums, return all the triplets [nums[i], nums[j],
//nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
//Notice that the solution set must not contain duplicate triplets.
// public class Qs_Exercise4 {

//     public static int name() {
        
//     }
//     public static void main (String args[]){
//         int nums[] = {-1,0,1,2,-1,-4};

//     }
// }