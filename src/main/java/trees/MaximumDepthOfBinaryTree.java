package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MaximumDepthOfBinaryTree {
    public static void main(String[] args) {

    }

    public int maxDepth(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        int depth=0;
        if (root == null) {
            return 0;
        }
        queue.offer(root);

        while (!queue.isEmpty()) {
            int level = queue.size();
            depth+=1;
            for (int i = 0; i < level; i++) {
                if (queue.peek().left != null) {
                    queue.offer(queue.peek().left);
                }
                if (queue.peek().right != null) {
                    queue.offer(queue.peek().right);
                }
            }

        }
        return depth;
    }
}

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
