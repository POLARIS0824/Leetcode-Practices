import java.util.Queue;
import java.util.LinkedList;

public class symmetric_tree_101 {
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

    // recursive
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return compare(root.left, root.right);
    }

    private boolean compare(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        if (left.val != right.val) return false;

        boolean compareOut = compare(left.left, right.right);
        boolean compareIn = compare(left.right, right.left);
        return compareOut && compareIn;
    }

    // non-recursive
    public boolean isSymmetric2(TreeNode root) {
        if (root == null) return true;

        Queue<TreeNode> Queue = new LinkedList<>();
        Queue.offer(root.left);
        Queue.offer(root.right);

        while (!Queue.isEmpty()) {
            TreeNode left = Queue.poll();
            TreeNode right = Queue.poll();
            if (left == null && right == null) continue;
            if (left == null || right == null) return false;
            if (left.val != right.val) return false;

            Queue.offer(left.left);
            Queue.offer(right.right);
            Queue.offer(left.right);
            Queue.offer(right.left);
        }
        return true;
    }
}
