public class integer_break_343 {
    public int integerBreak(int n) {
        // 7 -> 2, 2, 3  -> 12 -> 3, 4
        // 8 -> 3, 3, 2  -> 18
        // 9 -> 3, 3, 3  -> 27
        // 10 -> 3, 3, 4 -> 36 -> dp[7] * 3

        int[] dp = new int[n + 1];
        dp[2] = 1;

        // 2 <= n <= 58
        if (n == 2) {
            return dp[2];
        }

        for (int i = 3; i <= n; i++) {
            for (int j = 1; j <= i - j; j++) {
                int candidate = Math.max(j * (i - j), j * dp[i - j]);
                dp[i] = Math.max(dp[i], candidate);
            }
        }

        return dp[n];
    }

    // greedy solution
    public int mySolution(int n) {
        if (n == 2) return 1;
        if (n == 3) return 2;

        int res = 1;
        while (n > 4) {
            n -= 3;
            res *= 3;
        }

        return res * n;
    }
}
