import java.util.Scanner;

public class complete_knapsack_52 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int bagWeight = sc.nextInt();

        int[] weight = new int[n];
        int[] value = new int[n];

        for (int i = 0; i < n; i++) {
            weight[i] = sc.nextInt();
            value[i] = sc.nextInt();
        }

        int[][] dp = new int[n][bagWeight + 1];

        // 初始化
        // dp[0][i] 如果能放下weight[0]的话，就一直装，每一种物品有无限个
        for (int i = weight[0]; i <= bagWeight; i++) {
            dp[0][i] = dp[0][i - weight[0]] + value[0];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= bagWeight; j++) {
                if (j < weight[i]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - weight[i]] + value[i]);
                }
            }
        }

        System.out.println(dp[n][bagWeight]);
    }
}
