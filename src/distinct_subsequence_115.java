public class distinct_subsequence_115 {
    public int numDistinct(String s, String t) {
        // 以 i-1 为结尾的 s 子序列中出现以 j-1 为结尾的 t 的个数为 dp[i][j]
        int[][] dp = new int[s.length() + 1][t.length() + 1];

        // 注意初始化
        for (int i = 0; i < s.length(); i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length(); j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    // 使用匹配 + 不使用匹配
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[s.length()][t.length()];
    }
}
