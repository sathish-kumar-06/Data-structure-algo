package stackandqueue;

import java.util.Stack;

public class MinimumAbsoluteDifferenceInBST {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {

    }

    public int getMinimumDifference(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        Integer prev = null;
        int minDiff = Integer.MIN_VALUE;

        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            if (prev != null) {
                minDiff = Math.min(minDiff, curr.val - prev);
            }
            prev = curr.val;
            curr = curr.right;
        }
        return minDiff;
    }
}
