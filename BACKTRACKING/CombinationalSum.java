/* Given an array of positive integers arr[] and an integer x, The task is to find all unique combinations in arr[] where the sum is equal to x. 
The same repeated number may be chosen from arr[] an unlimited number of times. Elements in a combination (a1, a2, …, ak) must be printed in non-descending order. (ie, a1 <= a2 <= … <= ak). If there is no combination possible print “Empty”. */

// TC = O(k*(2^n)) where n is the size of array, and k is average length
// SC = O(k*x) where is x is number of possible combinations

import java.util.*;

public class CombinationalSum {
    public static ArrayList<ArrayList<Integer>> combinations(ArrayList<Integer> arr, int sum) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();

        // first do hashing since hashset does not always sort removing the duplicates
        // using HashSet and
        // Sorting the arrayList
        Set<Integer> s = new HashSet<>(arr);
        arr.clear();
        arr.addAll(s);
        Collections.sort(arr);

        find(ans, arr, sum, 0, temp);
        return ans;
    }

    public static void find(ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> arr, int sum, int idx,
            ArrayList<Integer> temp) {
        if (sum == 0) {
            // Adding deep copy of list to ans
            ans.add(new ArrayList<>(temp));
            return;
        }

        for (int i = idx; i < arr.size(); i++) {
            // checking that sum does not become negative
            if ((sum - arr.get(i)) >= 0) {
                // adding element which can contribute to sum
                temp.add(arr.get(i));
                find(ans, arr, sum - arr.get(i), i, temp);
                // removing element from list (backtracking)
                temp.remove(arr.get(i));
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();

        arr.add(2);
        arr.add(4);
        arr.add(6);
        arr.add(8);

        int sum = 8;

        ArrayList<ArrayList<Integer>> ans = combinations(arr, sum);

        if (ans.size() == 0) {
            System.out.println("empty");
            return;
        }

        for (int i = 0; i < ans.size(); i++) {
            System.out.print("(");
            for (int j = 0; j < ans.get(i).size(); j++) {
                System.out.print(ans.get(i).get(j));
            }
            System.out.print(")");
        }

    }
}
