public class maximum_binary_tree {
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

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return buildHelper(0, nums.length - 1, nums);
    }

    private TreeNode buildHelper(int left, int right, int[] nums) {
        if (right - left < 0) {
            return null;
        }

        if (right - left == 0) {
            return new TreeNode(nums[left]);
        }

        int maxIndex = left;
        int maxVal = nums[maxIndex];
        for (int i = left + 1; i <= right; i++) {
            if (nums[i] > maxVal) {
                maxVal = nums[i];
                maxIndex = i;
            }
        }

        TreeNode root = new TreeNode(maxVal);

        root.left = buildHelper(left, maxIndex - 1, nums);
        root.right = buildHelper(maxIndex + 1, right, nums);

        return root;
    }
}
