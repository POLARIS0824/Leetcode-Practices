// ⚠️ 巧妙利用 dp

public class edit_distance_72 {
    public int minDistance(String word1, String word2) {
        /*
            1. 插入
            2. 删除
            3. 替换
            4. 不动
         */
        // dp -> 最近编辑距离
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];

        // 注意初始化
        for (int i = 0; i <= word1.length(); i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= word2.length(); i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    // 不操作
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // word2 添加一个元素，相当于 word1 删除一个元素
                    dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
                }
            }
        }

        return dp[word1.length()][word2.length()];
    }
}
