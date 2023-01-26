// Maximum profit after buying and selling stocks with transaction fees
// We have an array of positive integers containing the price of stocks and transaction fee, the task is to find the maximum profit and the 
// difference of days on which you are getting the maximum profit

// TC = O(n^2); SC = O(1)

import java.util.*;
public class Qs_Exercise_21_3 {
    public static int maxProfit(int a[], int b[], int n, int fee) {
        int i, j, profit;
        int l, r, diff_day = 1, sum = 0;

        b[0] = 0;
        b[1] = diff_day;

        for(i = 1; i < n; i++){
            l = 0;
            r = diff_day;
            sum = 0;

            for(j = n-1; j >= i; j--){
                profit = (a[r] - a[l]) - fee;
                if(profit > 0){
                    sum = sum + profit;
                }
                l++;
                r++;
            }

            if(b[0] < sum){
                b[0] = sum;
                b[1] = diff_day;
            }

            diff_day++;
        }

        return 0;
    }

    public static void main(String[] args) {
        int arr[] = {6, 1, 7, 2, 8, 4};
        int n = arr.length;
        int b[] = new int[2];
        int tranFee = 2;

        maxProfit(arr, b, n, tranFee);
        System.out.print(b[0] + "," + b[1]);
    }
}
