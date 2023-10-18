// Minimum time required to fill given N slots
// We have an integer N which denotes the number of slots, and an array arr[] consisting of K integers in the range [1,N] repreand. 
// Each element of the array are in the range [1,N] which represents the indices of the filled slots. 
// At each unit of time, the index with filled slot fills the adjacent empty slots. The task is to find the minimum time taken to fill all the N slots

// TC = SC = O(n)

import java.util.LinkedList;
import java.io.*;
import java.util.*;

public class Qs_Exercise17_2 {
    public static void minTime(int arr[], int n, int k) {
        Queue<Integer> q = new LinkedList<>();

        boolean vis[] = new boolean[n+1];
        int time = 0;

        for(int i = 0; i < k; i++){
            q.add(arr[i]);
            vis[arr[i]] = true;
        }

        while(q.size() > 0) {
            for(int i = 0; i < q.size(); i++){
                int curr = q.poll();
                if(curr - 1 >= 1 && !vis[curr-1]){
                    vis[curr-1] = true;
                    q.add(curr-1);
                }

                if(curr + 1 <= n && !vis[curr+1]){
                    vis[curr+1] = true;
                    q.add(curr+1);
                }
            }
            time++;
        }

        System.out.println(time - 1);
    }

    public static void main(String args[]) {
        int n = 6;
        int arr[] = {2, 6};
        int k = arr.length;
        minTime(arr, n, k);
    }
}
