import java.util.HashMap;
import java.util.Map;

// Two Sum
// Given an array of integers arr[ ]and an integer target, return indices of the two numbers such that they add up to target.
// You may assume that each input would have exactly one solution, and you may not use the same element twice. You can return the answer in any order

public class Qs_Exercise18_2 {
    public static int[] twoSum(int arr[], int target) {
        Map<Integer, Integer> visited = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            // Diff = given target - number given at ith index
            int diff = target - arr[i];

            // Check if found difference is present in the MAP list
            if(visited.containsKey(diff)){
                // if diff in map matches with the ith index element in array
                return new int[] {i, visited.get(diff)};
            }

            // add arr element in map to match with future element if forms a pair
            visited.put(arr[i], i);
        }

        // if no matches are found
        return null;
    }

    public static void main(String args[]) {
        int arr[] = {2, 7, 11, 15};
        int target = 9;

        System.out.println(twoSum(arr, target));
    }
}
