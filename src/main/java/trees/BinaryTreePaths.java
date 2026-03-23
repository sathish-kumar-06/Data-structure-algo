package trees;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {


    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        String paths = String.valueOf(root.val);
        allPaths(root, ans, paths);
        return ans;
    }

    private void allPaths(TreeNode root, List<String> ans, String paths) {
        if (root.left == null && root.right == null) {
            ans.add(paths);
            return;
        }

        if (root.left != null) {
            String val = String.valueOf(root.left.val);
            allPaths(root.left, ans, paths + "->" + val);
        }
        if (root.right != null) {
            String val = String.valueOf(root.right.val);
            allPaths(root.right, ans, paths + "->" + val);
        }
    }

    public static void main(String[] args) {
        // Build tree manually
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);

        BinaryTreePaths sol = new BinaryTreePaths();
        List<String> result = sol.binaryTreePaths(root);

        System.out.println(result);
    }
}
