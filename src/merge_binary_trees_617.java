public class merge_binary_trees_617 {
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

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        return mergeHelper(root1, root2);
    }

    private TreeNode mergeHelper(TreeNode node1, TreeNode node2) {
//        if (node1 == null && node2 == null) {
//            return null;
//        }
        if (node1 == null) {
            return node2;
        }
        if (node2 == null) {
            return node1;
        }

        TreeNode root = new TreeNode(node1.val + node2.val);
        root.left = mergeHelper(node1.left, node2.left);
        root.right = mergeHelper(node1.right, node2.right);

        return root;
    }
}
