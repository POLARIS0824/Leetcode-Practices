import java.sql.Array;
import java.util.*;

public class average_of_levels_637 {
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

        public List<Double> averageOfLevels(TreeNode root) {
            List<Double> res = new ArrayList<>();
            if (root == null) return res;

            Deque<TreeNode> deque = new ArrayDeque<>();
            deque.offer(root);

            while (!deque.isEmpty()) {
                int size = deque.size();
                long sum = 0;
                for (int i = 0; i < size; i++) {
                    TreeNode node = deque.poll();
                    sum += node.val;

                    if (node.left != null) deque.offer(node.left);
                    if (node.right != null) deque.offer(node.right);
                }
                res.add((double) sum / size);
            }
            return res;
        }
    }
}
