import java.util.HashMap;
import java.util.Map;

public class inOrder_preOrder_construct_105 {
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

    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return buildHelper(preorder, inorder, 0, inorder.length - 1, 0, preorder.length - 1);
    }

    private TreeNode buildHelper(int[] preorder, int[] inorder, int inLeft,
                                 int inRight, int preLeft, int preRight) {
        if (inLeft > inRight || preLeft > preRight) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preLeft]);
        int rootIndex = map.get(preorder[preLeft]);
        int rightSize = inRight - rootIndex;
        
        root.left = buildHelper(preorder, inorder, inLeft, rootIndex - 1, preLeft + 1, preRight - rightSize);
        root.right = buildHelper(preorder, inorder, rootIndex + 1, inRight, preRight - rightSize + 1, preRight);

        return root;
    }
}
