import java.util.ArrayList;
import java.util.List;

public class 二叉树的中序遍历 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        walk(root, ans);
        return ans;
    }

    public void walk(TreeNode root, List<Integer> ans) {
        if(root == null) {
            return;
        }
        walk(root.left, ans);
        ans.add(root.val);
        walk(root.right, ans);
    }
}
