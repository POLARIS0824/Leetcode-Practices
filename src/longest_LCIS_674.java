public class longest_LCIS_674 {
    public int findLengthOfLCIS(int[] nums) {
        int res = 1;
        int temp = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i - 1]) {
                temp = 1;
            } else {
                temp++;
                res = Math.max(res, temp);
            }
        }

        return res;
    }
}
