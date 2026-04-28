// ⚠️ hard 最多两笔交易，不能同时参与多笔交易

public class best_stock_III_123 {
    public int maxProfit(int[] prices) {
        /*
            dp 数组有五个状态
            1. 没有操作 （其实我们也可以不设置这个状态）
            2. 第一次持有股票
            3. 第一次不持有股票
            4. 第二次持有股票
            5. 第二次不持有股票
         */
        int[][] dp = new int[prices.length][5];
        dp[0][1] = -prices[0];
        dp[0][3] = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = dp[i - 1][0];
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] + prices[i]);
            dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][2] - prices[i]);
            dp[i][4] = Math.max(dp[i - 1][4], dp[i - 1][3] + prices[i]);
        }

        return dp[prices.length - 1][4];
    }
}
