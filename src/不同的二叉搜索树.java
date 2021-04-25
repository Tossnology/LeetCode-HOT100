public class 不同的二叉搜索树 {
    public int numTrees(int n) {
        int[] f = new int[n + 1];

        f[0] = 1;
        f[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                f[i] += f[i - j] * f[j - 1];
            }
        }

        return  f[n];
    }
}
