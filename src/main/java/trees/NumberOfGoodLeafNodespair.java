package trees;

import java.util.ArrayList;
import java.util.List;

public class NumberOfGoodLeafNodespair {
    private int count = 0;

    public int countPairs(TreeNode root, int distance) {
        dfs(root, distance);
        return count;
    }

    // Returns list of distances from THIS node to each leaf below it
    private List<Integer> dfs(TreeNode node, int distance) {
        if (node == null) return new ArrayList<>();

        // Base case: leaf node → distance to parent = 1
        if (node.left == null && node.right == null) {
            return new ArrayList<>(List.of(1));
        }

        List<Integer> leftDists = dfs(node.left, distance);
        List<Integer> rightDists = dfs(node.right, distance);

        // Count good pairs across left and right subtrees
        for (int l : leftDists) {
            for (int r : rightDists) {
                if (l + r <= distance) {
                    count++;
                }
            }
        }

        // Bubble up: increment each distance by 1 (we moved up one level)
        List<Integer> result = new ArrayList<>();
        for (int d : leftDists) if (d + 1 < distance) result.add(d + 1); // prune: can never pair
        for (int d : rightDists) if (d + 1 < distance) result.add(d + 1); // prune: can never pair

        return result;
    }

    public static void main(String[] args) {

    }
}
