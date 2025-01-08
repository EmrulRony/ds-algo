package leetcode.array;

public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int lowestStockIndex = 0;
        for (int i = 1; i < prices.length - 1; i++) {
            if (prices[i] < prices[lowestStockIndex]) {
                lowestStockIndex = i;
            }
        }
        int highestStockIndex = lowestStockIndex;
        for (int j = highestStockIndex; j < prices.length; j++) {
            if (prices[j] > prices[highestStockIndex]) {
                highestStockIndex = j;
            }
        }
        int profit = prices[highestStockIndex] - prices[lowestStockIndex];
        return Math.max(profit, 0);
    }
}
