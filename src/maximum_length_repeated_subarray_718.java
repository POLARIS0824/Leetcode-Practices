public class maximum_length_repeated_subarray_718 {
    public int findLength(int[] nums1, int[] nums2) {
        // 以下标 i - 1 为结尾的 A，和以下标 j - 1 为结尾的 B，最长重复子数组长度为 dp[i][j]
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];
        int res = 0;

        for (int i = 1; i <= nums1.length; i++) {
            for (int j = 1; j <= nums2.length; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                if (dp[i][j] > res) res = dp[i][j];
            }
        }

        return res;
    }
}
