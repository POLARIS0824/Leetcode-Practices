public class convert_bst_greater_tree_538 {
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

    int sum;

    public TreeNode convertBST(TreeNode root) {
        // right -> root -> left
        if (root == null) {
            return null;
        }

        sum = 0;
        convertHelper(root);
        return root;
    }

    // 不需要操作返回值，直接修改 root.val 即可
    private void convertHelper(TreeNode root) {
        if (root == null) return;

        convertHelper(root.right);
        sum += root.val;
        root.val = sum;
        convertHelper(root.left);
    }
}
