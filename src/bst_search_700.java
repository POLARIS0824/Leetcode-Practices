public class bst_search_700 {
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

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }

        int isFound = val - root.val;
        if (isFound == 0) {
            return root;
        } else if (isFound > 0) {
            return searchBST(root.right, val);
        } else {
            return searchBST(root.left, val);
        }
    }
}
