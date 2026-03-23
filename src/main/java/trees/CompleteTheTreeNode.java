package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CompleteTheTreeNode {

    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        int leftDepth = leftDepth(root);
        int rightDepth = rightDepth(root);
        if (leftDepth == rightDepth) {
            return (int) Math.pow(2, leftDepth) - 1;
        } else {
            return 1 + countNodes(root.left) + countNodes(root.right);
        }

    }

    private int leftDepth(TreeNode root) {
        int depth = 0;
        while (root != null) {
            root = root.left;
            depth += 1;
        }
        return depth;
    }

    private int rightDepth(TreeNode root) {
        int depth = 0;
        while (root != null) {
            root = root.right;
            depth += 1;
        }
        return depth;
    }

    static TreeNode buildTree(int[] vals) {
        if (vals == null || vals.length == 0) return null;
        TreeNode root = new TreeNode(vals[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;
        while (!queue.isEmpty() && i < vals.length) {
            TreeNode curr = queue.poll();
            if (i < vals.length && vals[i] != -1) {
                curr.left = new TreeNode(vals[i]);
                queue.offer(curr.left);
            }
            i++;
            if (i < vals.length && vals[i] != -1) {
                curr.right = new TreeNode(vals[i]);
                queue.offer(curr.right);
            }
            i++;
        }
        return root;
    }

    public static void main(String[] args) {
        CompleteTheTreeNode sol = new CompleteTheTreeNode();

        // Test 1: [1,2,3,4,5,6]  → expected: 6
        TreeNode root1 = buildTree(new int[]{1, 2, 3, 4, 5, 6});
        System.out.println("Test 1: " + sol.countNodes(root1) + "  (expected: 6)");

        // Test 2: [1,2,3,4,5,6,7] perfect tree → expected: 7
//        TreeNode root2 = buildTree(new int[]{1, 2, 3, 4, 5, 6, 7});
//        System.out.println("Test 2: " + sol.countNodes(root2) + "  (expected: 7)");
//
//        // Test 3: [] empty tree → expected: 0
//        TreeNode root3 = buildTree(new int[]{});
//        System.out.println("Test 3: " + sol.countNodes(root3) + "  (expected: 0)");
//
//        // Test 4: [1] single node → expected: 1
//        TreeNode root4 = buildTree(new int[]{1});
//        System.out.println("Test 4: " + sol.countNodes(root4) + "  (expected: 1)");

    }
}
