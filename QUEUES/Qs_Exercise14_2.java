// Connect n ropes with minimum cost
// Given are N ropes of different lengths, the task is to connect these ropes into one rope with
// minimum cost, such that the cost to connect two ropes is equal to the sum of their lengths.

// TC = Sc = O(n)

import java.util.*;

public class Qs_Exercise14_2 {

    static int minCost(int arr[], int n) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 0; i < n; i++) {
            pq.add(arr[i]);
        }

        int res = 0;
        while(pq.size() > 1) {
            int first = pq.poll();
            int second = pq.poll();

            res += first+second;
            pq.add(first+second);
        }
        return res;
    }
    public static void main(String args[]) {
        int len[] = {4, 3, 2, 6};
        int size = len.length;
        System.out.println("Total Cost is : " + minCost(len, size));
    }
}
