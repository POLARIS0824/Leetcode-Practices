import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class combination_II_40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        combineHelper(res, new ArrayList<>(), candidates, target, 0, 0);
        return res;
    }

    private void combineHelper(List<List<Integer>> res, List<Integer> temp, int[] candidates,
                               int target, int sum, int index) {
        // base case
        if (sum == target) {
            res.add(new ArrayList<>(temp));
            return;
        }

        // backtracking
        for (int i = index; i < candidates.length; i++) {
            if (sum + candidates[i] > target) {
                break;
            }
            // 防止重复，此处为 “树层去重”
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }
            temp.add(candidates[i]);
            combineHelper(res, temp, candidates, target, sum + candidates[i], i + 1);
            temp.removeLast();
        }
    }
}
