// ⚠️ 经典 dp -> 01 背包

public class partition_equal_subset_sum_416 {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1) return false;

        int target = sum / 2;
        // dp[j] 表示： 容量（所能装的重量）为 j 的背包，所背的物品价值最大可以为 dp[j]
        int[] dp = new int[target + 1];

        for (int i = 0; i < nums.length; i++) {
            for (int j = target; j >= nums[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }
        }

        if (dp[target] == target) return true;
        return false;
    }
}
