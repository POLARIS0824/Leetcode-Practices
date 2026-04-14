public class wiggle_subsequence_376 {
    public int wiggleMaxLength(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int up = 1, down = 1;
        /*
         * up：到当前位置为止，最后一步是“上升”时的最长摆动子序列长度
         * down：到当前位置为止，最后一步是“下降”时的最长摆动子序列长度
         */
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                up = down + 1;
            } else if (nums[i] < nums[i - 1]) {
                down = up + 1;
            }
        }
        return Math.max(up, down);
    }
}
