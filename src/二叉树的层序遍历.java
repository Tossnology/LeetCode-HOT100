import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 二叉树的层序遍历 {
    public static void main(String[] args) {
        //new一个test对象
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        /*TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(3);*/

        /*TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(2);
        root.right.left = new TreeNode(2);*/

        /*TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.right = new TreeNode(1);
        root.left.right.left = new TreeNode(2);
        root.right = new TreeNode(1);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(2);*/


        Map<Integer, List<Integer>> a = new HashMap<>();

        二叉树的层序遍历 test = new 二叉树的层序遍历();

        test.printTree(root, a, 0);

        System.out.println(a.toString());
    }

    public void printTree(TreeNode root, Map<Integer, List<Integer>> a, int i) {
        if (root == null) {
            return;
        }

        if (!a.containsKey(i)) {
            a.put(i, new ArrayList<>());
            a.get(i).add(root.val);
        } else {
            a.get(i).add(root.val);
        }
        i++;
        printTree(root.left, a, i);
        printTree(root.right, a, i);

    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        Map<Integer, List<Integer>> a = new HashMap<>();
        printTree(root, a, 0);

        for (int i = 0; i < a.size(); i++) {
            result.add(a.get(i));
        }

        return result;
    }
}
