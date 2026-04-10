import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class combination_sum_III_216 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> temp = new LinkedList<>();
        combineHelper(res, temp, k, n, 0, 1);
        return res;
    }

    private void combineHelper(List<List<Integer>> res, List<Integer> temp,
                               int k, int n, int sum, int index) {
        // base cases
        if (sum > n) {
            return;
        }

        if (temp.size() == k) {
            if (sum == n) {
                res.add(new ArrayList<>(temp));
            }
        }

        // backtracking
        // already: temp.size() need: k - temp.size()
        for (int i = index; i <= 9 - (k - temp.size()) + 1; i++) {
            temp.add(i);
            combineHelper(res, temp, k, n, sum + i, i + 1);
            temp.removeLast();
        }
    }
}
