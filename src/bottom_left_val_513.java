import java.util.ArrayDeque;
import java.util.Deque;

public class bottom_left_val_513 {
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

    public int findBottomLeftValue(TreeNode root) {
        if (root == null) return 0; // unnecessary

        Deque<TreeNode> deque = new ArrayDeque<>();
        Deque<TreeNode> left = new ArrayDeque<>();
        deque.offer(root);

        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.poll();
                if (i == 0) {
                    left.offer(node);
                }
                if (node.left != null) deque.offer(node.left);
                if (node.right != null) deque.offer(node.right);
            }
        }
        return left.peekLast().val;
    }

    // faster
    public int findBottomRightValue2(TreeNode root) {
        if (root == null) return 0;

        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        TreeNode node = root;

        while (!deque.isEmpty()) {
            node = deque.poll();
            if (node.right != null) deque.offer(node.right);
            if (node.left != null) deque.offer(node.left);
        }
        return node.val;
    }

    // dfs
    int maxDepth = -1;
    int res = 0;

    public int findBottomRightValue3(TreeNode root) {
        if (root == null) return 0;

        dfs(root, 0);
        return res;
    }

    private void dfs(TreeNode node, int depth) {
        if (node == null) return;

        // first time come, must be the left node
        if (depth > maxDepth) {
            depth = maxDepth;
            res = node.val;
        }

        dfs(node.left, depth + 1);
        dfs(node.right, depth + 1);
    }
}
