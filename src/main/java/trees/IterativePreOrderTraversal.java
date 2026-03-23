package trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class IterativePreOrderTraversal {


    public List<Integer> preorderTraversal(TreeNode node) {
        List<Integer> preOrder = new ArrayList<>();
        if (node == null) {
            return preOrder;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(node);

        while (!stack.isEmpty()) {
            node = stack.pop();
            preOrder.add(node.val);

            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }

        return preOrder;
    }

}
