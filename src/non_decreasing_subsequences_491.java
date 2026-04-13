import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class non_decreasing_subsequences_491 {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Helper(res, temp, nums, 0, nums[0]);
        return res;
    }

    private void Helper(List<List<Integer>> res, List<Integer> temp,
                        int[] nums, int start, int prev) {
        // base case
        if (temp.size() >= 2) {
            res.add(new ArrayList<>(temp));
        }

        // backtracking
        // ! 使用 hashSet 去重！
        Set<Integer> set = new HashSet<>();

        for (int i = start; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                continue;
            }

            if (temp.isEmpty() || nums[i] >= temp.getLast()) {
                set.add(nums[i]);
                temp.add(nums[i]);
                Helper(res, temp, nums, i + 1, nums[i]);
                temp.removeLast();
            }
        }
    }

    public static void main(String[] args) {
        non_decreasing_subsequences_491 res = new non_decreasing_subsequences_491();
        res.findSubsequences(new int[]{4, 6, 7, 7});
    }
}
