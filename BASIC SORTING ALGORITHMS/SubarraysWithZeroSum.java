import java.util.*;

class Pair{
    int first, second;
    Pair(int a, int b){
        first = a;
        second = b;
    }
}

public class SubarraysWithZeroSum {
    public static ArrayList<Pair> findSubArrays(int arr[], int n){
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

        // create an empty vector of pairs to store subarray starting and ending index
        ArrayList<Pair> out = new ArrayList<>();

        // maintains length of sum so far
        int sum = 0;

        for(int i = 0; i < n; i++){
            sum += arr[i];

            // if sum is 0, we found a subarray starting from index 0 and ending at index i
            if(sum == 0){
                out.add(new Pair(0, i));
            }

            ArrayList<Integer> al = new ArrayList<>();

            // If sum already exists in map there exists at-least one subarray ending at index i with 0 sum
            if(map.containsKey(sum)){
                al = map.get(sum);
                for(int j = 0; j < al.size(); j++){
                    out.add(new Pair(al.get(j)+1, i));
                }
            }

            al.add(i);
            map.put(sum, al);
        }

        return out;
    }


    public static void print(ArrayList<Pair> out){
        for(int i = 0; i < out.size(); i++){
            Pair p = out.get(i);
            System.out.print(p.first + p.second);
        }
    }
    public static void main(String[] args) {
        int[] arr = {6, 3, -1, -3, 4, -2, 2, 4, 6, -12, -7};
        int n = arr.length;
        
        ArrayList<Pair> out = findSubArrays(arr, n);
            
        // if we did not find any subarray with 0 sum, then subarray does not exists
        if (out.size() == 0){
            System.out.println("No subarray exists");
        }else{
            print(out);
        }
    }
}
