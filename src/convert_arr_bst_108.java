public class convert_arr_bst_108 {
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

    public TreeNode sortedArrayToBST(int[] nums) {
        // [-10, -3, 0, 5, 9, 11, 16]
        // 0     1   2  3  4  5   6
        // 3 -> 1 & 5

        // [-10, -3, 0, 5, 9, 11]
        // 0     1   2  3  4  5
        if (nums == null || nums.length == 0) return null;

        int rootVal = nums[nums.length / 2];
        TreeNode root = new TreeNode(rootVal);
        root.left = buildHelper(nums, 0, nums.length / 2 - 1);
        root.right = buildHelper(nums, nums.length / 2 + 1, nums.length - 1);

        return root;
    }

    private TreeNode buildHelper(int[] nums, int low, int high) {
        if (low > high) return null;

        int rootVal = nums[low + (high - low) / 2];
        TreeNode root = new TreeNode(rootVal);
        root.left = buildHelper(nums, low, low + (high - low) / 2 - 1);
        root.right = buildHelper(nums, low + (high - low) / 2 + 1, high);

        return root;
    }
}
