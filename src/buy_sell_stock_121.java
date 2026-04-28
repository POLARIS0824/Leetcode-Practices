public class buy_sell_stock_121 {
    public int maxProfit(int[] prices) {
        // dp[i][0] 第 i 天持有股票所得最多现金
        // dp[i][1] 第 i 天不持有股票所得最多现金
        int[][] dp = new int[prices.length + 1][2];
        dp[0][0] = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], -prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
        }

        return dp[prices.length - 1][1];
    }

    // greedy algorithm
    public int mySolution(int[] prices) {
        int res = 0;
        int low = Integer.MAX_VALUE;

        for (int i = 0; i < prices.length; i++) {
            low = Math.min(prices[i], low);
            res = Math.max(res, prices[i] - low);
        }

        return res;
    }
}
