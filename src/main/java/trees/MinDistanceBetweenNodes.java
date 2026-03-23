package trees;

import java.util.*;

public class MinDistanceBetweenNodes {

    static class Node {
        int data;
        Node left, right;
        Node(int data) { this.data = data; }
    }

    // ── Step 1: Find LCA ──────────────────────────────────────────────
    private static Node findLCA(Node root, int a, int b) {
        if (root == null) return null;

        // If current node is either a or b, it could be the LCA
        if (root.data == a || root.data == b) return root;

        Node leftLCA  = findLCA(root.left,  a, b);
        Node rightLCA = findLCA(root.right, a, b);

        // Both sides found something → current node is LCA
        if (leftLCA != null && rightLCA != null) return root;

        // Return whichever side found something
        return leftLCA != null ? leftLCA : rightLCA;
    }

    // ── Step 2: Find distance from root to target ─────────────────────
    private static int findDistance(Node root, int target, int dist) {
        if (root == null) return -1;

        if (root.data == target) return dist;

        // Search left subtree
        int left = findDistance(root.left, target, dist + 1);
        if (left != -1) return left;  // found in left, no need to search right

        // Search right subtree
        return findDistance(root.right, target, dist + 1);
    }

    // ── Step 3: Combine ───────────────────────────────────────────────
    public static int minDistance(Node root, int a, int b) {
        Node lca = findLCA(root, a, b);
        int distA = findDistance(lca, a, 0);
        int distB = findDistance(lca, b, 0);
        return distA + distB;
    }

    // ── Build tree helper ─────────────────────────────────────────────
    static Node buildTree(int[] vals) {
        if (vals == null || vals.length == 0) return null;
        Node root = new Node(vals[0]);
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;
        while (!queue.isEmpty() && i < vals.length) {
            Node curr = queue.poll();
            if (i < vals.length && vals[i] != -1) {
                curr.left = new Node(vals[i]);
                queue.offer(curr.left);
            }
            i++;
            if (i < vals.length && vals[i] != -1) {
                curr.right = new Node(vals[i]);
                queue.offer(curr.right);
            }
            i++;
        }
        return root;
    }

    // ── Main ──────────────────────────────────────────────────────────
    public static void main(String[] args) {

        //        1
        //       / \
        //      2   3
        //     / \   \
        //    4   5   6

        Node root = buildTree(new int[]{1, 2, 3, 4, 5, -1, 6});

        // Test 1: dist(4, 6) → 4→2→1→3→6 = 4 edges
        System.out.println("dist(4,6) = " + minDistance(root, 4, 6) + "  (expected: 4)");

//        // Test 2: dist(4, 5) → 4→2→5 = 2 edges
//        System.out.println("dist(4,5) = " + minDistance(root, 4, 5) + "  (expected: 2)");
//
//        // Test 3: dist(2, 6) → 2→1→3→6 = 3 edges
//        System.out.println("dist(2,6) = " + minDistance(root, 2, 6) + "  (expected: 3)");
//
//        // Test 4: dist(4, 2) → 4→2 = 1 edge (one is ancestor of other)
//        System.out.println("dist(4,2) = " + minDistance(root, 4, 2) + "  (expected: 1)");
//
//        // Test 5: dist(1, 6) → 1→3→6 = 2 edges
//        System.out.println("dist(1,6) = " + minDistance(root, 1, 6) + "  (expected: 2)");
    }
}
