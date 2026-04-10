import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class combination_sum_39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(candidates);
        combineHelper(res, candidates, temp, target, 0, 0);
        return res;
    }

    private void combineHelper(List<List<Integer>> res, int[] candidates,
                               List<Integer> temp, int target, int sum, int index) {
        // base case
        if (sum == target) {
            res.add(new ArrayList<>(temp));
            return;
        }

        // backtracking
        for (int i = index; i < candidates.length; i++) {
            if (candidates[i] + sum > target) {
                break;
            }
            temp.add(candidates[i]);
            combineHelper(res, candidates, temp, target, sum + candidates[i], i);
            temp.removeLast();
        }
    }
}
