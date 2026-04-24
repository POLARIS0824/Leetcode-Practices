public class house_robber_198 {
    public int rob(int[] nums) {
        // dp[i] 表示偷到第 i 个房子时可以拿到的最高金额
        int[] dp = new int[nums.length + 1];

        // 有两种可能，i-1 偷过，i 不能再偷
        //           i-2 偷过，i 可以偷
        for (int i = 1; i <= nums.length; i++) {
            if (i > 1) {
                dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
            } else {
                dp[i] = nums[i - 1];
            }
        }

        return dp[nums.length];
    }

    // O(1) 空间写法
    public int mySolution(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        int prev2 = 0; // dp[i - 2]
        int prev1 = 0; // dp[i - 1]

        for (int num : nums) {
            int cur = Math.max(prev1, prev2 + num);
            prev2 = prev1;
            prev1 = cur;
        }

        return prev1;
    }
}
