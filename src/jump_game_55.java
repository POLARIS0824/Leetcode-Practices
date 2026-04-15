// ⚠️ 用最大跳跃范围思考 而不是 思考每一步跳多少

public class jump_game_55 {
    public boolean canJump(int[] nums) {
        int maxReach = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > maxReach) {
                return false;
            }
            maxReach = Math.max(maxReach, i + nums[i]);
            if (maxReach >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        jump_game_55 test = new jump_game_55();
        System.out.println(test.canJump(new int[]{3, 0, 8, 2, 0, 0, 1}));
    }
}
