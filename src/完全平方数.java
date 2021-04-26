public class 完全平方数 {
    public int numSquares(int n) {
        int[] ans = new int[n+1];
        int[] squares = new int[n+1];

        for(int i = 0; (i+1) * (i+1) <= n; i++) {
            squares[i] = (i+1) * (i+1);
        }

        ans[0] = 0;
        ans[1] = 1;

        for(int i = 2; i <= n; i++) {
            int min = ans[i-1];
            for(int j = 0; squares[j] > 0 && i >= squares[j]; j++) {
                if(ans[i-squares[j]] < min) {
                    min = ans[i-squares[j]];
                }
            }
            ans[i] = min + 1;
        }

        return ans[n-1];
    }

    public static void main(String[] args) {
        //new一个test对象
        完全平方数 test = new 完全平方数();
        //自定义测试用例
        int num = 12;
        long startTime = System.currentTimeMillis();
        //输出结果
        test.numSquares(num);
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");

    }
}
