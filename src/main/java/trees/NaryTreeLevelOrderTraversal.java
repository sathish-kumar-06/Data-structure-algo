package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(Node root) {
        Queue<Node> queue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> currList = new ArrayList<>();
            int size = queue.size();
            while (size-- > 0) {
                Node curr = queue.poll();
                currList.add(curr.val);
                if (curr.children != null) {
                    for (Node child : curr.children) {
                        queue.offer(child);
                    }
                }
            }
            result.add(currList);
        }
        return result;
    }
}
