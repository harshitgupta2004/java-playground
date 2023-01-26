// Minimum Operations to Halve Array Sum
// We have an array Arr[], the task is to find out the minimum number of operations to make the sum of array elements lesser or equal to half of its initial value. 
// In one such operation, it is allowed to half the value of any array element

// TC = O(nlogn)
// Sc = O(n)

import java.io.*;
import java.util.*;

public class Qs_Exercise17_4 {
    static int minops(ArrayList<Integer> nums){
        int sum = 0;
        for(int i = 0; i < nums.size(); i++){
            sum += nums.get(i);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < nums.size(); i++){
            pq.add(-nums.get(i));
        }

        double temp = sum;
        int cnt = 0;
        while(temp > sum/2){
            int x = -pq.peek();
            pq.remove();
            temp -= Math.ceil((x * 1.0/2));
            pq.add(x/2);
            cnt++;
        }
        return cnt;
    }

    public static void main(String args[]) {
        ArrayList<Integer> nums = new ArrayList<>(List.of(4, 6, 3, 9, 10, 2));
        int count = minops(nums);
        System.out.println(count);
    }
}
