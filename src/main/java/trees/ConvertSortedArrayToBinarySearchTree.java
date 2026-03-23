package trees;

public class ConvertSortedArrayToBinarySearchTree {
    public static TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    private static TreeNode helper(int[] nums, int st, int end) {

        if (st > end) {
            return null;
        }

        int mid = st + (end - st) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = helper(nums, st, mid - 1);
        node.right = helper(nums, mid + 1, end);

        return node;
    }

    public static void main(String[] args) {
        int[] arr = {-10, -3, 0, 5, 9};
        System.out.println(sortedArrayToBST(arr));
    }
}
