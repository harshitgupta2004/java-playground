// BUY ADN SELL STOCKS

public class Stocks {

    public static int buyAndSellStocks(int prices[]){
        int buyPrice = Integer.MAX_VALUE;
        int maxProfit = 0; 

        for (int i = 0; i < prices.length; i++){
            if (buyPrice < prices[i]) { // profit - prices[i] means selling price or current aaj ka price
                int profit = prices[i] - buyPrice; //today's profit
                maxProfit = Math.max(maxProfit, profit); // total days ka milake jo bhi max profit aayega vo ye hai
            } else {
                buyPrice = prices[i]; // buyprice ko update krke kr dunga current price ke equal
            }
        }

        return maxProfit;
    }
    public static void main (String args[]) {
        int prices[] = {7, 1, 5, 3, 6, 4};
        System.out.println(buyAndSellStocks(prices));
    }
}
// Time Complexity = O(n)