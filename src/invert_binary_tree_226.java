import java.util.ArrayDeque;
import java.util.Deque;

public class invert_binary_tree_226 {
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

    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);

        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.poll();
                TreeNode temp = node.left;
                node.left = node.right;
                node.right = temp;
                if (node.left != null) deque.offer(node.left);
                if (node.right != null) deque.offer(node.right);
            }
        }
        return root;
    }

    // faster
    // use recursive
    public TreeNode  invertTree2(TreeNode root) {
            if (root == null) return null;

            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
            root.left = invertTree(root.left);
            root.right = invertTree(root.right);
            return root;
    }
}
