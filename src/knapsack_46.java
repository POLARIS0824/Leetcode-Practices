import java.util.Scanner;

public class knapsack_46 {
    /**
     * 第一行包含两个正整数，第一个整数 M 代表研究材料的种类，第二个正整数 N，代表小明的行李空间。
     *
     * 第二行包含 M 个正整数，代表每种研究材料的所占空间。
     *
     * 第三行包含 M 个正整数，代表每种研究材料的价值。
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int bagWeight = sc.nextInt();
        int[] weight = new int[m];
        int[] value = new int[m];
        for (int i = 0; i < m; i++) {
            weight[i] = sc.nextInt();
        }
        for (int i = 0; i < m; i++) {
            value[i] = sc.nextInt();
        }

        // dp[i][j] -> 从下标为[0-i]的物品里任意取，放进容量为j的背包，价值总和最大是多少
        int[][] dp = new int[m][bagWeight + 1];

        // initialization
        for (int i = weight[0]; i <= bagWeight; i++) {
            dp[0][i] = value[0];
        }

        // dp
        for (int i = 1; i < m; i++) {              // 物品
            for (int j = 0; j <= bagWeight; j++) { // 容量
                if (j < weight[i]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);
                }
            }
        }

        System.out.println(dp[m - 1][bagWeight]);

        sc.close();
    }

    // 一维滚动数组
    public void mySolution(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int bagWeight = sc.nextInt();
        int[] weight = new int[m];
        int[] value = new int[m];
        for (int i = 0; i < m; i++) {
            weight[i] = sc.nextInt();
        }
        for (int i = 0; i < m; i++) {
            value[i] = sc.nextInt();
        }

        int[] dp = new int[bagWeight + 1];

        // ⚠️ 一维数组遍历容量需要倒序
        for (int i = 0; i < m; i++) {
            for (int j = bagWeight; j >= weight[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
            }
        }

        System.out.println(dp[bagWeight]);

        sc.close();
    }
}
