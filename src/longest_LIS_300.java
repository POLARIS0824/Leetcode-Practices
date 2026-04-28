import java.util.Arrays;

public class longest_LIS_300 {
    public int lengthOfLIS(int[] nums) {
        // dp[i] 表示到 i 处 LIS 的最长距离
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        int res = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

            if (dp[i] > res) res = dp[i];
        }

        return res;
    }
}
