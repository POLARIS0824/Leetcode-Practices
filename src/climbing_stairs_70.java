public class climbing_stairs_70 {
    public int climbStairs(int n) {
        // dp[i] -> 到达第 i 阶的方法数
        int[] dp = new int[n + 1];

        // 递推公式 dp[i] = dp[i - 1] + dp[i - 2]

        // 初始化
        dp[0] = 1;
        dp[1] = 1;

        if (n <= 1) {
            return dp[n];
        }

        // dp
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    // more precisely
    public int mySolution(int n) {
        if (n <= 1) {
            return n;
        }

        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    // Use DP method -> 卡码 57
}
