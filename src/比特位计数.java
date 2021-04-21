public class 比特位计数 {
    public int[] countBits(int num) {
        int[] ans = new int[num + 1];

        ans[0] = 0;

        for (int i = 1; i < num + 1; i++) {
            int tmp1 = i-1;
            int tmp2 = ans[i-1];
            while ((tmp1 & 1) == 1) {
                tmp2--;
                tmp1 = tmp1 >> 1;
            }
            tmp2++;
            ans[i] = tmp2;
        }

        return ans;
    }

    public static void main(String[] args) {
        //new一个test对象
        比特位计数 test = new 比特位计数();
        //自定义测试用例
        int num = 5;
        long startTime = System.currentTimeMillis();
        //输出结果
        test.countBits(num);
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");

    }
}
