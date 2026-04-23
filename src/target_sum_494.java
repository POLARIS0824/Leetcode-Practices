public class target_sum_494 {
    public int findTargetSumWays(int[] nums, int target) {
        // positive: p
        // abs(negative): sum - p
        // p - (sum - p) = target
        // 2 * p - sum = target
        // p = (sum + target) / 2

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if ((sum + target) % 2 != 0 || Math.abs(target) > sum) {
            return 0;
        }

        int aim = (sum + target) / 2;

        // dp[i][j] 表示用 nums[0..i] 凑满 j 有多少种方法
        int[][] dp = new int[nums.length][aim + 1];

        dp[0][0] = nums[0] == 0 ? 2 : 1;
        if (nums[0] != 0 && nums[0] <= aim) {
            dp[0][nums[0]] = 1;
        }

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j <= aim; j++) {
                dp[i][j] = dp[i - 1][j]; // 不选 nums[i]
                if (j >= nums[i]) {
                    dp[i][j] += dp[i - 1][j - nums[i]]; // 选
                }
            }
        }

        return dp[nums.length - 1][aim];
    }

    // 一维数组 dp
    public int mySolution(int[] nums, int target) {
        // positive: p
        // negative: s - p
        // p - (s - p) = target
        // p = (s + target) / 2
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if ((sum + target) % 2 != 0 || Math.abs(target) > sum) {
            return 0;
        }

        int aim = (sum + target) / 2;
        int[] dp = new int[aim + 1];
        dp[0] = 1;

        for (int num : nums) { // 遍历物品
            for (int j = aim; j >= num; j--) { // 遍历容量
                dp[j] += dp[j - num];
            }
        }

        return dp[aim];
    }
}
