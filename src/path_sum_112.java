import java.util.ArrayDeque;
import java.util.Deque;

public class path_sum_112 {
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

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;

        return dfs(root, targetSum, 0);
    }

    private boolean dfs(TreeNode node, int targetSum, int sum) {
        if (node == null) return false;

        if (node.left == null && node.right == null) {
            return targetSum == sum + node.val;
        }

        boolean left = dfs(node.left, targetSum, sum + node.val);
        boolean right = dfs(node.right, targetSum, sum + node.val);
        return left || right;
    }
}
