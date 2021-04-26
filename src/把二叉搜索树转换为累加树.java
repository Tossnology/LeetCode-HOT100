public class 把二叉搜索树转换为累加树 {
    public TreeNode convertBST(TreeNode root) {
        if(root == null) {
            return null;
        }

        root.val += max(convertBST(root.right));
        convertBST(root.left);
        update(root.left, root.val);

        return root;
    }

    public int max(TreeNode root) {
        if(root == null) {
            return 0;
        }

        if(root.left == null) {
            return root.val;
        } else {
            return max(root.left);
        }
    }

    public void update(TreeNode root, int val) {
        if(root == null) {
            return;
        }

        root.val += val;
        update(root.left, val);
        update(root.right, val);
    }
}
