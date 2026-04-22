// ⚠️ 01背包应用

public class last_stone_weight_II_1049 {
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int stone : stones) {
            sum += stone;
        }
        int target = sum / 2;
        // 容量为 j 的背包，最多可以背重量为 dp[j] 的石头
        int[] dp = new int[target + 1];

        for (int i = 0; i < stones.length; i++) {
            for (int j = target; j >= stones[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i]);
            }
        }

        // target <= sum / 2
        // S1 = dp[target]
        // S2 = sum - dp[target]
        // diff = S2 - S1
        return sum - 2 * dp[target];
    }
}
