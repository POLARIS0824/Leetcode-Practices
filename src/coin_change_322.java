import java.util.Arrays;

public class coin_change_322 {
    public int coinChange(int[] coins, int amount) {
        // dp[i] 表示凑成 i 的最少硬币数量
        int[] dp = new int[amount + 1];

        // ⚠️ 注意初始化，dp[0] = 0，其余为最大值
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                if (dp[i - coin] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        coin_change_322 test = new coin_change_322();
        System.out.println(test.coinChange(new int[]{2}, 3));
    }
}
