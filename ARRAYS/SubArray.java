// public class SubArray {
//     //print subarrays
//     public static void SubArray(int numbers[]){
//         int ts = 0; //total subarrays
//         for(int i = 0; i < numbers.length; i++){
//             int start = i;
//             for (int j = i; j < numbers.length; j++){
//                 int end = j;
//                 for (int k = start; k <= end; k++){ //its only use is to print
//                     System.out.print(numbers[k]+" "); //subarray
//                 }
//                 ts++;
//                 System.out.println();
//             }
//             System.out.println();
//         }
//         System.out.println("Total subaarays = "+ ts);
//     }
//     public static void main (String args[]) {
//         int numbers[] = {2,4,6,8,10};
//         SubArray(numbers);
//     }
// }



// MAX SUBARRAY SUM
// public class SubArray {
//     public static void maxSubarraySum(int numbers[]){
//         int currSum = 0;
//         int maxSum = Integer.MIN_VALUE;

//         for(int i = 0; i < numbers.length; i++){
//             int start = i;
//             for (int j = i; j < numbers.length; j++){
//                 int end = j;
//                 currSum = 0;
//                 for (int k = start; k <= end; k++){ //its only use is to print
//                     // subarray sum
//                     currSum += numbers[k];
//                 }
//                 System.out.println(currSum); //all possible sums print
//                 if (maxSum < currSum) {
//                     maxSum = currSum;
//                 }
//             }
//         }
//         System.out.println("Max Sum = " + maxSum); //max sum print
//     }
//     public static void main (String args[]) {
//         int numbers[] = {1, -2, 6, -1, 3};
//         maxSubarraySum(numbers);
//     }
// } //Time Complexity = n^3 ; brute approach 



// MAX SUBARRAY SUM BY PREFIX APPROACH
// prefix array - 
// 0th index mtlb 0th se phele tk ka sum
// 2th index mtlb 0 se 2 tk ka sum
// public class SubArray {
//     public static void maxSubarraySum(int numbers[]){
//         int currSum = 0;
//         int maxSum = Integer.MIN_VALUE;
//         int prefix[] = new int[numbers.length];

//         prefix[0] = numbers[0];
//         // calculate prefix array
//         for (int i = 1; i < prefix.length; i++){
//             prefix[i] = prefix[i-1] + numbers[i];
//         }

//         for(int i = 0; i < numbers.length; i++){
//             int start = i;
//             for (int j = i; j < numbers.length; j++){
//                 int end = j;
                
//                 currSum = start == 0 ? prefix[end] : prefix[end] - prefix[start-1];
                
//                 if (maxSum < currSum) {
//                     maxSum = currSum;
//                 }
//             }
//         }
//         System.out.println("Max Sum = " + maxSum); //max sum print
//     }
//     public static void main (String args[]) {
//         int numbers[] = {1, -2, 6, -1, 3};
//         maxSubarraySum(numbers);
//     } 
// } // Time Complexity - n^2



// MAX SUBARRAY SUM - KADANE'S ALGORITHM
public class SubArray {
    public static void Kadane(int numbers[]){
        int cs = 0;
        int ms = Integer.MIN_VALUE;
        
        for (int i = 0; i < numbers.length; i++){
            cs = cs + numbers[i];
            if (cs < 0) {
                cs = 0;
            }
            ms = Math.max(cs, ms);
        }

        System.out.println("Max Sum = " + ms); //max sum print
    }
    public static void main (String args[]) {
        int numbers[] = {-2, -3, 4, -1, -2, 1, 5, -3};
        Kadane(numbers);
    } 
} // Time Complexity = n;
// You can make one special condition where all elements are negative;
// so, you have to take their lowest negative value in that case
