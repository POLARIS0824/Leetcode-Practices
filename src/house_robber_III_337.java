// ⚠️ 树形 DP

import java.util.HashMap;
import java.util.Map;

public class house_robber_III_337 {
    private Map<TreeNode, Integer> map = new HashMap<>();

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

    // 记忆化递推
    public int rob1(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return root.val;
        if (map.containsKey(root)) return map.get(root);

        // 偷父节点
        int val1 = root.val;
        if (root.left != null) {
            val1 += rob(root.left.left) + rob(root.left.right);
        }
        if (root.right != null) {
            val1 += rob(root.right.left) + rob(root.right.right);
        }

        // 不偷父节点
        int val2 = rob(root.left) + rob(root.right);
        map.put(root, Math.max(val1, val2));

        return Math.max(val1, val2);
    }

    // 树形 DP
    public int rob(TreeNode root) {
        int[] res = postOrder(root);
        return Math.max(res[0], res[1]);
    }

    // 二叉树后序遍历，返回偷与不偷得到的金钱
    // 0 不偷， 1 偷
    private int[] postOrder(TreeNode node) {
        if (node == null) return new int[]{0, 0};

        int[] left = postOrder(node.left);
        int[] right = postOrder(node.right);

        // 偷当前节点
        int val1 = node.val + left[0] + right[0];

        // 不偷当前节点
        int val2 = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

        return new int[]{val2, val1};
    }
}
