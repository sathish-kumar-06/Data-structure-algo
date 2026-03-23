package trees;

public class SubtreeOfAnotherTree {

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        String firstTree = preOrderTransaversal(root);
        String secTree = preOrderTransaversal(root);

        return firstTree.contains(secTree);

    }

    private String preOrderTransaversal(TreeNode root) {
        if (root == null) {
            return "null";
        }

        StringBuilder builder = new StringBuilder("^");
        builder.append(root.val);
        builder.append(preOrderTransaversal(root.left));
        builder.append(preOrderTransaversal(root.right));

        return builder.toString();
    }
}
