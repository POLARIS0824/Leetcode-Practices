public class coin_change_518 {
    public int change(int amount, int[] coins) {
        // dp[i] 表示凑成总金额为 i 的方法数量
        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for (int coin : coins) { // 遍历物品
            for (int j = coin; j <= amount; j++) { // 遍历容量，注意完全背包不能倒序
                dp[j] += dp[j - coin];
            }
        }

        return dp[amount];
    }
}
