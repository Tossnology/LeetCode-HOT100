public class 二叉树的最大深度 {
    public void printTree(TreeNode root, int depth, TreeNode tmp) {
        if (root == null) {
            return;
        }
        depth++;
        if(depth > tmp.val) {
            tmp.val = depth;
        }
        printTree(root.left, depth, tmp);
        printTree(root.right, depth, tmp);
    }

    public int maxDepth(TreeNode root) {
        TreeNode tmp = new TreeNode(0);
        printTree(root, 0, tmp);
        return tmp.val;
    }
}
