// ⚠️ 二维 01 背包应用

public class ones_and_zeros_474 {
    public int findMaxForm(String[] strs, int m, int n) {
        // dp[i][j] -> i0 & j1
        int[][] dp = new int[m + 1][n + 1];

        for (String str : strs) { // 遍历物品
            int numOnes = 0, numZeros = 0;
            for (char c : str.toCharArray()) {
                if (c == '1') {
                    numOnes++;
                } else {
                    numZeros++;
                }
            }

            for (int i = m; i >= numZeros; i--) { // 遍历容量
                for (int j = n; j >= numOnes; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - numZeros][j - numOnes] + 1);
                }
            }
        }

        return dp[m][n];
    }
}
