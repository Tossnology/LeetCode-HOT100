import java.util.ArrayList;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
}

public class 对称二叉树 {
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


        ArrayList<String> a = new ArrayList<>();
        ArrayList<String> r = new ArrayList<>();

        对称二叉树 test = new 对称二叉树();

        test.printTree(root, a);
        test.printTree2(root, r);

        System.out.println(a.toString());
        System.out.println(r.toString());
        System.out.println(a.equals(r));
    }

    public void printTree(TreeNode root, ArrayList<String> a) {
        if (root == null) {
            a.add("null");
            return;
        }
        if (root.left == null && root.right == null) {
            a.add(String.valueOf(root.val));
            return;
        }
        printTree(root.left, a);
        printTree(root.right, a);
        a.add(String.valueOf(root.val));
    }

    public void printTree2(TreeNode root, ArrayList<String> a) {
        if (root == null) {
            a.add("null");
            return;
        }
        if (root.left == null && root.right == null) {
            a.add(String.valueOf(root.val));
            return;
        }
        printTree2(root.right, a);
        printTree2(root.left, a);
        a.add(String.valueOf(root.val));
    }

    public boolean isSymmetric(TreeNode root) {
        boolean result = false;

        ArrayList<String> a = new ArrayList<>();
        ArrayList<String> r = new ArrayList<>();

        printTree(root, a);
        printTree2(root, r);

        result = a.equals(r);

        return result;
    }
}
