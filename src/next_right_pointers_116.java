import java.util.ArrayDeque;
import java.util.Deque;

public class next_right_pointers_116 {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public Node connect(Node root) {
        if (root == null) { return null; }

        Deque<Node> deque = new ArrayDeque<>();
        deque.add(root);

        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                Node node = deque.poll();
                if (i != size - 1) {
                    node.next = deque.peek();
                } else {
                    node.next = null;
                }
                if (node.left != null) { deque.offer(node.left); }
                if (node.right != null) { deque.offer(node.right); }
            }
        }
        return root;
    }
}
