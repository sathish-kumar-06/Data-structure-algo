package trees;

import java.util.*;

public class FindDuplicateSubtrees {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> res = new ArrayList<>();
        Map<String, ArrayList<TreeNode>> map = new HashMap<>();
        dfs(root, map);

        for (Map.Entry<String, ArrayList<TreeNode>> m : map.entrySet()) {
            if (m.getValue().size() > 1) {
                res.add(m.getValue().get(0));
            }
        }
        return res;
    }

    private String dfs(TreeNode root, Map<String, ArrayList<TreeNode>> map) {
        if (root == null) {
            return "$";
        }

        String leftTree = dfs(root.left, map);
        String rightTree = dfs(root.right, map);

        String subTree = leftTree + "$" + rightTree + "$" + root.val;
        ArrayList<TreeNode> ls = map.getOrDefault(subTree, new ArrayList<TreeNode>());
        ls.add(root);
        map.put(subTree, ls);
        return subTree;
    }
}
