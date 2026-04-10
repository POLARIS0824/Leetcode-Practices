import java.util.ArrayList;
import java.util.List;

public class validate_bst_98 {
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

    private List<Integer> list = new ArrayList<>();

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
//        List<Integer> list = new ArrayList<>();
        inOrder(root);
        if (list.size() == 1) return true;
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i + 1) <= list.get(i)) {
                return false;
            }
        }
        return true;
    }

    private void inOrder(TreeNode node) {
        if (node == null) return;
        inOrder(node.left);
        list.add(node.val);
        inOrder(node.right);
    }

    private long prev = Long.MIN_VALUE;

    // faster
    public boolean isValidBST2(TreeNode root) {
        if (root == null) return true;

        if (!isValidBST2(root.left)) return false;

        if (root.val <= prev) return false;
        prev = root.val;

        return isValidBST2(root.right);
    }
}
