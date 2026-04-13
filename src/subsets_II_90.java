import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class subsets_II_90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Helper(res, temp, nums, 0);
        return res;
    }

    private void Helper(List<List<Integer>> res, List<Integer> temp,
                        int[] nums, int start) {
        // base case
        res.add(new ArrayList<>(temp));

        // backtracking
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }

            temp.add(nums[i]);
            Helper(res, temp, nums, i + 1);
            temp.removeLast();
        }
    }
}
