public class 从前序与中序遍历序列构造二叉树 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        TreeNode root = new TreeNode(preorder[0]);
        dfs(root, 0, n-1, preorder, inorder, 0);
        return root;
    }

    public void dfs(TreeNode root, int left, int right,int[] preorder, int[] inorder, int index) {
        for(int i = left; i <= right; i++) {
            if(inorder[i] == root.val) {
                int ln = i - left;
                int rn = right - i;
                if(ln == 0) {
                    root.left = null;
                } else {
                    root.left = new TreeNode(preorder[index + 1]);
                    dfs(root.left, left, i - 1, preorder, inorder, index + 1);
                }

                if(rn == 0) {
                    root.right = null;
                } else {
                    root.right = new TreeNode(preorder[index + ln + 1]);
                    dfs(root.right, i + 1, right, preorder, inorder, index + ln + 1);
                }
            }
        }
    }
}
