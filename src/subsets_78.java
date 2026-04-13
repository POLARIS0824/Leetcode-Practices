import java.util.ArrayList;
import java.util.List;

public class subsets_78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Helper(res, temp, nums, 0);
        return res;
    }

    private void Helper(List<List<Integer>> res, List<Integer> temp,
                        int [] nums, int start) {
        // base case
        res.add(new ArrayList<>(temp));

        // backtracking
        for (int end = start; end < nums.length; end++) {
            temp.add(nums[end]);
            Helper(res, temp, nums, end + 1);
            temp.removeLast();
        }
    }
}
