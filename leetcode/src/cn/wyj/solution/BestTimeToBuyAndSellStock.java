package cn.wyj.solution;

public class BestTimeToBuyAndSellStock {
    //O(n^2)
    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (profit < prices[j] - prices[i])
                    profit = prices[j] - prices[i];
            }
        }
        return profit;
    }

    public int maxProfit2(int[] prices) {
        int buy = Integer.MAX_VALUE, profit = 0;
        for (int i : prices) {
            buy = Math.min(buy, i);
            profit = Math.max(profit, i - buy);
        }
        return profit;
    }
}
