package trees;

import java.util.*;

public class Main {

    // ── TreeNode definition ──────────────────────────────────────────
    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    // ── Solution ─────────────────────────────────────────────────────
    static int count = 0;

    public static int countPairs(TreeNode root, int distance) {
        count = 0; // reset for each test case
        dfs(root, distance);
        return count;
    }

    private static List<Integer> dfs(TreeNode node, int distance) {
        if (node == null) return new ArrayList<>();

        if (node.left == null && node.right == null) {
            System.out.println("  [LEAF] node=" + node.val + " → return [1]");
            return new ArrayList<>(List.of(1));
        }

        List<Integer> leftDists = dfs(node.left, distance);
        List<Integer> rightDists = dfs(node.right, distance);

        System.out.println("\n  [NODE] node=" + node.val);
        System.out.println("         leftDists  = " + leftDists);
        System.out.println("         rightDists = " + rightDists);

        for (int l : leftDists) {
            for (int r : rightDists) {
                System.out.println("         checking " + l + " + " + r + " = " + (l + r)
                        + (l + r <= distance ? " ≤ " : " > ")
                        + distance
                        + (l + r <= distance ? " ✓ count++" : " ✗ skip"));
                if (l + r <= distance) count++;
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int d : leftDists) if (d + 1 < distance) result.add(d + 1);
        for (int d : rightDists) if (d + 1 < distance) result.add(d + 1);

        System.out.println("         returning = " + result + "  (count so far = " + count + ")");
        return result;
    }

    // ── Helper: build tree from level-order array ─────────────────────
    // Use -1 to represent null  e.g. [1, 2, 3, -1, -1, 4, 5]
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

    // ── Main ──────────────────────────────────────────────────────────
    public static void main(String[] args) {

        // ── Test 1: [1,2,3,4,5,6,7], distance=3 → expected: 2
        System.out.println("========== TEST 1 ==========");
        TreeNode root1 = buildTree(new int[]{1, 2, 3, 4, 5, 6, 7});
        System.out.println("Tree: [1,2,3,4,5,6,7]  distance=3");
        int result1 = countPairs(root1, 3);
        System.out.println(">>> Output: " + result1 + "  (expected: 2)\n");

        // ── Test 2: [1,2,3,4], distance=3 → expected: 1
//        System.out.println("========== TEST 2 ==========");
//        TreeNode root2 = buildTree(new int[]{1, 2, 3, 4});
//        System.out.println("Tree: [1,2,3,4]  distance=3");
//        int result2 = countPairs(root2, 3);
//        System.out.println(">>> Output: " + result2 + "  (expected: 1)\n");
//
//        // ── Test 3: [1,2,3,4,5,6,7], distance=2 → expected: 2
//        System.out.println("========== TEST 3 ==========");
//        TreeNode root3 = buildTree(new int[]{1, 2, 3, 4, 5, 6, 7});
//        System.out.println("Tree: [1,2,3,4,5,6,7]  distance=2");
//        int result3 = countPairs(root3, 2);
//        System.out.println(">>> Output: " + result3 + "  (expected: 2)\n");
//
//        // ── Test 4: single leaf root → expected: 0
//        System.out.println("========== TEST 4 ==========");
//        TreeNode root4 = buildTree(new int[]{1});
//        System.out.println("Tree: [1]  distance=1");
//        int result4 = countPairs(root4, 1);
//        System.out.println(">>> Output: " + result4 + "  (expected: 0)\n");
    }
}
