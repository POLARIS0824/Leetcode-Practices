public class maximum_subarray_53 {
    public int maxSubArray(int[] nums) {
        int res = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            res = Math.max(res, sum);
            if (sum < 0) {
                sum = 0;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        maximum_subarray_53 res = new maximum_subarray_53();
        System.out.println(res.maxSubArray(new int[]{-1, -1, -1}));
    }
}
