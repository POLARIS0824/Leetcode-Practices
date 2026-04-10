import org.antlr.v4.runtime.tree.Tree;

public class minimum_abs_diff_bst_530 {
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

    private int minVal = Integer.MAX_VALUE;
    private TreeNode prev;

    public int getMinimumDifference(TreeNode root) {
//        if (root == null) return 0;
        inOrder(root);
        return minVal;
    }

    private void inOrder(TreeNode root) {
        if (root == null) return;
        inOrder(root.left);
        if (prev != null) {
            minVal = Math.min(minVal, root.val - prev.val);
        }
        prev = root;
        inOrder(root.right);
    }
}
