package trees;

public class CountGoodNodesInBinaryTree {
    public int goodNodes(TreeNode root) {
        return countGoodNodes(root,root.val);
    }

    private int countGoodNodes(TreeNode root, int maxVal) {
        if (root == null){
            return 0;
        }
        int res=root.val>maxVal?1:0;
        maxVal=Math.max(maxVal, root.val);
        res+=countGoodNodes(root.left,maxVal);
        res+=countGoodNodes(root.right,maxVal);
        return maxVal;
    }
}
