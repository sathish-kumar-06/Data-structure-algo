package trees;

import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.List;

public class BoundryTraversal {
    public ArrayList<Integer> boundaryTraversal(TreeNode root) {

        ArrayList<Integer> res = new ArrayList<>();

        if (root == null) {
            return res;
        }
        if (!isLeaf(root)) {
            res.add(root.val);
        }
        addLeftTreeBoundry(root, res);
        addLeaves(root,res);
        addRightBoundary(root, res);
        return res;
    }

    private void addRightBoundary(TreeNode root, ArrayList<Integer> res) {
        TreeNode cur = root.right;
        ArrayList<Integer> tmp = new ArrayList<>();
        while (cur != null) {
            if (!isLeaf(cur)) tmp.add(cur.val);
            if (cur.right != null) cur = cur.right;
            else cur = cur.left;
        }
        // Reverse and add to main result
        for (int i = tmp.size() - 1; i >= 0; --i) {
            res.add(tmp.get(i));
        }
    }

    private void addLeaves(TreeNode root,ArrayList<Integer> res) {
        if (isLeaf(root)) {
            res.add(root.val);
            return;
        }
        if (root.left != null) addLeaves(root.left, res);
        if (root.right != null) addLeaves(root.right, res);
    }

    private static void addLeftTreeBoundry(TreeNode root, ArrayList<Integer> res) {
        TreeNode curr = root.left;

        while (curr != null) {
            if (!isLeaf(root)) {
                res.add(curr.val);
            }
            if (root.left != null) {
                curr = root.left;
            } else {
                curr = root.right;
            }
        }
    }

    public static boolean isLeaf(TreeNode root) {
        return (root.left == null) && (root.right == null);
    }
}
