import java.util.ArrayList;
import java.util.List;

public class permutations_II_47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        Helper(res, temp, nums, used);
        return res;
    }

    private void Helper(List<List<Integer>> res, List<Integer> temp,
                        int[] nums, boolean[] used) {
        // base case
        if (temp.size() == nums.length) {
            res.add(new ArrayList<>(temp));
            return;
        }

        // backtracking
        boolean[] use = new boolean[21];
        for (int i = 0; i < nums.length; i++) {
            if (use[nums[i] + 10] || used[i]) {
                continue;
            }

            used[i] = true;
            use[nums[i] + 10] = true;
            temp.add(nums[i]);
            Helper(res, temp, nums, used);
            temp.removeLast();
            used[i] = false;
        }
    }
}
