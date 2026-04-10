import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Nary_tree_level_order_429 {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) { this.val = _val; }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        Deque<Node> deque = new ArrayDeque<>();
        deque.offer(root);

        while (!deque.isEmpty()) {
            int size = deque.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node node = deque.poll();
                list.add(node.val);
                if (node.children != null) {
                    for (Node child : node.children) deque.offer(child);
                }
            }
            res.add(list);
        }
        return res;
    }
}
