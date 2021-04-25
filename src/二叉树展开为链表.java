public class 二叉树展开为链表 {
    public void flatten(TreeNode root) {
        if(root == null) {
            return;
        }

        flatten(root.left);
        flatten(root.right);

        TreeNode tmp = root.right;
        root.right = root.left;
        root.left = null;

        TreeNode cur = root;
        while(cur.right != null) {
            cur = cur.right;
        }
        cur.right = tmp;
    }

    public static void main(String[] args) {
        //new一个test对象

        //自定义测试用例

        long startTime = System.currentTimeMillis();
        //输出结果

        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");

    }
}
