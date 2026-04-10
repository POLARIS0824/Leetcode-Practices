import java.util.HashMap;
import java.util.Map;

public class inOrder_postOrder_construct_106 {
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

    private Map<Integer, Integer> inOrderMap = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        TreeNode root = new TreeNode(postorder.length - 1);
        for (int i = 0; i < inorder.length; i++) {
            inOrderMap.put(inorder[i], i);
        }

        return buildHelper(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }

    // inorder [9, 3, 15, 20, 7]
    // postorder [9, 15, 7, 20, 3]

    // use index instead of sub-array
    private TreeNode buildHelper(int[] inorder, int[] postorder, int inLeft,
                             int inRight, int postLeft, int postRight) {
        if (inLeft > inRight || postLeft > postRight) {
            return null;
        }

        TreeNode root = new TreeNode(postorder[postRight]);
        // get the index in inOrder
        int rootIndex = inOrderMap.get(postorder[postRight]);
        int leftSize = rootIndex - inLeft;

        root.left = buildHelper(inorder, postorder, inLeft, rootIndex - 1, postLeft, postLeft + leftSize - 1);
        root.right = buildHelper(inorder, postorder, rootIndex + 1, inRight, postLeft + leftSize, postRight - 1);

        return root;
    }
}
