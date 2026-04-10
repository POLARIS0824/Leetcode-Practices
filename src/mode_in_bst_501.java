import java.util.ArrayList;
import java.util.List;

public class mode_in_bst_501 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private int frequency = 0;
    private int maxFreq = 0;
    private TreeNode prev = null;
    private List<Integer> list = new ArrayList<>();

    public int[] findMode(TreeNode root) {
        inOrder(root);
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    private void inOrder(TreeNode root) {
        if (root == null) return;

        inOrder(root.left);

        if (prev == null || prev.val != root.val) {
            frequency = 1;
        } else {
            frequency++;
        }

        if (frequency == maxFreq) {
            list.add(root.val);
        } else if (frequency > maxFreq) {
            maxFreq = frequency;
            list.clear();
            list.add(root.val);
        }
        prev = root;

        inOrder(root.right);
    }
}
