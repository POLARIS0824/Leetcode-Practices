import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class combinations_77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new LinkedList<>();
        combineHelper(res, new ArrayList<Integer>(), n, k, 1);
        return res;
    }

    public void combineHelper(List<List<Integer>> res, List<Integer> temp, int n, int k, int index) {
        if (temp.size() == k) {
            // !必须使用深拷贝！
            res.add(new ArrayList<>(temp));
            return;
        }

        // backtracking
        // need: k - temp.size()
        for (int i = index; i <= n - (k - temp.size()) + 1; i++) {
            temp.add(i);
            combineHelper(res, temp, n, k, i + 1);
            temp.removeLast();
        }
    }
}
