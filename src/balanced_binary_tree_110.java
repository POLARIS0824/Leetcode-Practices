public class balanced_binary_tree_110 {
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

    // O(n^2)
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;

        int left = countHeight(root.left);
        int right = countHeight(root.right);

        if (Math.abs(left - right) > 1) return false;

        return isBalanced(root.left) && isBalanced(root.right);
    }

    private int countHeight(TreeNode node) {
        if (node == null) return 0;

        int l = countHeight(node.left);
        int r = countHeight(node.right);
        return Math.max(l, r) + 1;
    }

    // faster O(n)
    public boolean isBalanced2(TreeNode root) {
        return countHeight2(root) >= 0;
    }
    
    private int countHeight2(TreeNode node) {
        if (node == null) return 0;

        int leftHeight = countHeight2(node.left);
        int rightHeight = countHeight2(node.right);

        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        } else {
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }
}
