public class maximum_subarray_53 {
    public int maxSubArray(int[] nums) {
        int res = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            res = Math.max(res, sum);
            if (sum < 0) {
                sum = 0;
            }
        }
        return res;
    }

    // DP
    public int mySolution(int[] nums) {
        int[] dp = new int[nums.length + 1];

        // ⚠️ 注意不一定是 dp[nums.length] 最大
        int res = Integer.MIN_VALUE;
        for (int i = 1; i <= nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i - 1], nums[i - 1]);
            if (dp[i] > res) res = dp[i];
        }

        return res;
    }

    public static void main(String[] args) {
        maximum_subarray_53 res = new maximum_subarray_53();
        System.out.println(res.maxSubArray(new int[]{-1, -1, -1}));

        System.out.println(res.mySolution(new int[]{-1, -1, -1}));
    }
}
