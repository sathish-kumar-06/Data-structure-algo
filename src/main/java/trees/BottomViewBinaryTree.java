package trees;

import java.util.*;

public class BottomViewBinaryTree {

    static class Pair {
        TreeNode node;
        int level;

        Pair(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }

    }

    public ArrayList<Integer> bottomView(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Queue<Pair> queue = new LinkedList<>();
        Map<Integer, Integer> map = new TreeMap<>();
        queue.offer(new Pair(root, 0));

        while (!queue.isEmpty()) {
            Pair curr = queue.poll();
            map.put(curr.level, curr.node.val);
            if (curr.node.left != null) {
                queue.offer(new Pair(curr.node.left, curr.level - 1));
            }
            if (curr.node.right != null) {
                queue.offer(new Pair(curr.node.right, curr.level + 1));
            }
        }

        result.addAll(map.values());
        return result;


    }
}
