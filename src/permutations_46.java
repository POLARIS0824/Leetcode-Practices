import java.util.ArrayList;
import java.util.List;

public class permutations_46 {
    public List<List<Integer>> permute(int[] nums) {
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
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            used[i] = true;
            temp.add(nums[i]);
            Helper(res, temp, nums, used);
            temp.removeLast();
        }
    }
}
