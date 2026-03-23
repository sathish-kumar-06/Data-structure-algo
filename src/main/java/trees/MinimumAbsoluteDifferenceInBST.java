package trees;

public class MinimumAbsoluteDifferenceInBST {

    TreeNode prev = null;
    int minDiff = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        if (root == null) return minDiff;

        // 1. Traverse Left
        getMinimumDifference(root.left);

        // 2. Process Current Node
        if (prev != null) {
            minDiff = Math.min(minDiff, Math.abs(root.val - prev.val));
        }
        prev = root; // Update prev for the next node in sequence

        // 3. Traverse Right
        getMinimumDifference(root.right);

        return minDiff;
    }
    public static void main(String[] args) {
        MinimumAbsoluteDifferenceInBST solution = new MinimumAbsoluteDifferenceInBST();

        // Creating a sample BST:
        //      4
        //     / \
        //    2   6
        //   / \
        //  1   3
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        int result = solution.getMinimumDifference(root);
        System.out.println("Minimum Absolute Difference: " + result);
    }
}
