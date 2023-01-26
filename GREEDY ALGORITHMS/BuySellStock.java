// Best Time to Buy and Sell Stock 
// Given an array prices[] of length N, representing the prices of the stocks on different days, the task is to find the maximum profit possible for buying 
// and selling the stocks on different days using transactions where at most one transaction is allowed.Note: Stock must be bought before being sold.

// TC = O(n)
// SC = O(1)

import java.util.*;

public class BuySellStock {

    public static int maxProfit(int prices[], int n) {
        int buy = prices[0], max_Profit = 0;
        for(int i = 1; i < n; i++){
            if(buy > prices[i]) {
                buy = prices[i];
            } else if(prices[i] - buy >max_Profit) {
                max_Profit = prices[i] - buy;
            }
        }

        return max_Profit;
    }
    public static void main(String args[]) {
        int prices[] = {7, 6, 4, 3, 1};
        int n = prices.length;
        int max_Profit = maxProfit(prices, n);
        System.out.println(max_Profit);
    }
}
