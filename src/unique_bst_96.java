// ⚠️ 左右子树的思维慢慢推导

public class unique_bst_96 {
    public int numTrees(int n) {
        // 选择不同的节点作为根节点
        // dp[i] 表示 i 个节点时 bst 的数量
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        // dp[3] = dp[2] * dp[0] + dp[1] * dp[1] + dp[0] * dp[2]
        // dp[2] = dp[1] * dp[0] + dp[0] * dp[1]
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[i - j] * dp[j - 1];
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        unique_bst_96 test = new unique_bst_96();
        System.out.println(test.numTrees(3));
    }
}
