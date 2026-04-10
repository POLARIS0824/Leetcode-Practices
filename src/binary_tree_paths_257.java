import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class binary_tree_paths_257 {
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

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) return res;

        dfs(root, res, "");
        return res;
    }

    private void dfs(TreeNode node, List<String> res, String path) {
        if (node == null) return;

        if (node.left == null && node.right == null) {
            res.add(new StringBuilder(path).append(node.val).toString());
            return;
        }
        String newPath = new StringBuilder(path).append(node.val).append("->").toString();
        dfs(node.left, res, newPath);
        dfs(node.right, res, newPath);
    }
}
