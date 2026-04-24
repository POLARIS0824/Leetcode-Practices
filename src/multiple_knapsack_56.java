// ⚠️ 多重背包 -> 01 背包变种

import java.util.Scanner;

public class multiple_knapsack_56 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int bagWeight = sc.nextInt();
        int n = sc.nextInt();

        int[] weight = new int[n];
        int[] value = new int[n];
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) weight[i] = sc.nextInt();
        for (int i = 0; i < n; i++) value[i] = sc.nextInt();
        for (int i = 0; i < n; i++) nums[i] = sc.nextInt();

        int[] dp = new int[bagWeight + 1];

        for (int i = 0; i < n; i++) { // 物品
            for (int j = bagWeight; j >= weight[i]; j--) { // 容量
                // 遍历拿取当前物品的个数
                for (int k = 1; k <= nums[i] && (j - k * weight[i] >= 0); k++) {
                    dp[j] = Math.max(dp[j], dp[j - k * weight[i]] + k * value[i]);
                }
            }
        }

        System.out.println(dp[bagWeight]);
    }
}
