package cn.wyj.solution;

public class BestTimeToBuyAndSellStockIII {
    //Brute Force
    public int maxProfit(int[] prices) {
        int buy1 = Integer.MAX_VALUE;
        // 在每次买/卖之后的利润
        int afterSell1 = 0;
        int afterBuy2 = Integer.MIN_VALUE;
        int afterSell2 = 0;

        for (int curPrice :
                prices) {
            // 第一次买入价格，越小越好，和视频里的“借钱买”的意思是一样
            buy1 = Math.min(buy1, curPrice);
            // 第一次卖出后获得的利润，越大越好
            afterSell1 = Math.max(afterSell1, curPrice - buy1);
            // 用第一次交易的利润做第二次买入后获得的利润，越大越好
            afterBuy2 = Math.max(afterBuy2, afterSell1 - curPrice);
            // 第二次卖出后获得的利润，越大越好
            afterSell2 = Math.max(afterSell2, afterBuy2 + curPrice);
        }
        return afterSell2; // 最终，获得最大利润
    }
}
