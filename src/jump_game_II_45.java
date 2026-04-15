public class jump_game_II_45 {
    public int jump(int[] nums) {
        int res = 0;
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return res;
        }

        int cur = 0;
        int next = 0;
        for (int i = 0; i < nums.length; i++) {
            next = Math.max(next, nums[i] + i);
            if (i == cur) {
                res++;
                cur = next;
                if (next >= nums.length - 1) break;
            }
        }
        return res;
    }
}
