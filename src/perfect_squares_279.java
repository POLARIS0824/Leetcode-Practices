import java.util.Arrays;

public class perfect_squares_279 {
    public int numSquares(int n) {
        // dp[i] 表示和为 i 的完全平方数的最小数量
        // 完全背包
        int[] dp = new int[n + 1];

        Arrays.fill(dp, n + 1);
        dp[0] = 0;

        for (int i = 1; i * i <= n; i++) { // 遍历物品
            int square = i * i;
            for (int j = square; j <= n; j++) { // 遍历背包
                dp[j] = Math.min(dp[j], dp[j - square] + 1);
            }
        }

        return dp[n];
    }

//    private boolean isSquare(int n) {
//        if (n < 0) return false;
//        int root = (int)Math.sqrt(n);
//        return root * root == n;
//    }
}
