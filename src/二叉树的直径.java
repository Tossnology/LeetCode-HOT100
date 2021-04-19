public class 二叉树的直径 {
    public int diameterOfBinaryTree(TreeNode root) {
        int result = 0;

        if (root == null || (root.left == null && root.right == null)) {
            return 0;
        }

        if (root.left != null) {
            result += maxBranch(root.left) + 1;
        }

        if (root.right != null) {
            result += maxBranch(root.right) + 1;
        }

        int resultL = diameterOfBinaryTree(root.left);
        int resultR = diameterOfBinaryTree(root.right);

        return Math.max(result, Math.max(resultL, resultR));
    }

    public int maxBranch(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return 0;
        }
        return Math.max(maxBranch(root.left), maxBranch(root.right)) + 1;
    }
}
