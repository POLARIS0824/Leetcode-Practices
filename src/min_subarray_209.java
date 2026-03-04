public class min_subarray_209 {
    public int minSubarrayLen(int target, int[] nums) {
        // target = 7, nums = [2,3,1,2,4,3]
        int n = nums.length;
        int res = n + 1;
        int sum = 0;
        int left = 0, right = 0;
        for (; right < n; right++) {
            sum += nums[right];
            while (sum - nums[left] >= target) {
                sum -= nums[left];
                left++;
            }
            if (sum >= target) res = Math.min(res, right - left + 1);
        }
        return res <= n ? res : 0;
    }
}
