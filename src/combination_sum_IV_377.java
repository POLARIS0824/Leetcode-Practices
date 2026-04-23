// 完全背包 -> 排列问题

public class combination_sum_IV_377 {
    public int combinationSum4(int[] nums, int target) {
        // dp[i] 表示目标为 i 的组合数量 （实际上是求排列）
        int[] dp = new int[target + 1];
        dp[0] = 1;

        for (int i = 0; i <= target; i++) {
            for (int num : nums) {
                if (i >= num) {
                    dp[i] += dp[i - num];
                }
            }
        }

        return dp[target];
    }
}
