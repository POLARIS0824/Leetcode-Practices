import java.util.ArrayDeque;
import java.util.Deque;

public class complete_tree_nodes_222 {
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

    public int countNodes(TreeNode root) {
        if (root == null) return 0;

        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        int count = 0;

        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.poll();
                count++;
                if (node.left != null) deque.offer(node.left);
                if (node.right != null) deque.offer(node.right);
            }
        }
        return count;
    }

    // faster
    public int countNodes2(TreeNode root) {
        if (root == null) return 0;

        int depthLeft = 0;
        int depthRight = 0;
        TreeNode left = root.left;
        TreeNode right = root.right;
        while (left != null) {
            depthLeft++;
            left = left.left;
        }
        while (right != null) {
            depthRight++;
            right = right.right;
        }
        if (depthLeft == depthRight) {
            return (2 << depthLeft) - 1; // 2 ^ n - 1
        } else {
            return countNodes2(root.left) + countNodes2(root.right) + 1;
        }
    }
}
