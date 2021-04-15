public class 翻转二叉树 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode tmp;
        if (root.left != null) {
            tmp = root.left;
        } else {
            tmp = null;
        }

        if (root.right != null) {
            root.left = root.right;
        } else {
            root.left = null;
        }

        root.right = tmp;

        if (root.left != null) {
            invertTree(root.left);
        }
        if (root.right != null) {
            invertTree(root.right);
        }

        return root;
    }
}
