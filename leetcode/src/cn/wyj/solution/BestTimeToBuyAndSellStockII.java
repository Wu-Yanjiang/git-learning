package cn.wyj.solution;

public class BestTimeToBuyAndSellStockII {
    public int maxProfit(int[] prices) {
        //一段时间最大的利润 = 这段时间最高值 - 最低值
        //不管你什么策略，这就是最大的利润了
        //所以可以连减的正值，表示利润
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1])
                profit += prices[i] - prices[i - 1];
        }
        return profit;
    }
}
