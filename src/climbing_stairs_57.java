// ⚠️ 完全背包应用

import java.util.Scanner;

public class climbing_stairs_57 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        // dp[i] 表示爬到 i 阶有多少种办法
        int[] dp = new int[n + 1];
        dp[0] = 1;

        // 实际上是排列
        for (int i = 0; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (i >= j) {
                    dp[i] += dp[i - j];
                }
            }
        }

        System.out.println(dp[n]);
    }
}
