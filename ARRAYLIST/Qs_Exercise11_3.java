import java.util.ArrayList;

// Most Frequent Number following Key
// You are given an integer Arraylist nums. You are also given an integer key, which is present in nums.
// For every unique integer target in nums, count the number of times target immediately follows an occurrence of key in nums. 
// In other words, count the number of indices i such that:
//0 <= i <= nums.size() - 2,
//nums.get(i) == key and,
//nums.get(i+1) == target.
//Return the target with the maximum count

public class Qs_Exercise11_3 {

    public static int mostFrequent(ArrayList<Integer> nums, int key) {
        int[] result = new int[1000];

        for(int i =0; i < nums.size()-1; i++) {
            if(nums.get(i) == key) {
                result[nums.get(i+1)-1]++;
            }
        }

        int max = Integer.MIN_VALUE;
        int ans = 0;

        for(int i = 0; i < 1000; i++) {
            if(result[i] > max) {
                max = result[i];
                ans = i+1;
            }
        }

        return ans;
    }
    public static void main(String args[]) {
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(1); nums.add(100); nums.add(200); nums.add(1); nums.add(100);
        int key = 1;
        System.out.println(mostFrequent(nums, key));
    }
}
