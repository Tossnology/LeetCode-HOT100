public class 最大子序和 {
    public int maxSubArray(int[] nums) {
        if (nums.length == 1){
            return nums[0];
        }else {
            int current_sum = 0;
            int last_sum = 0;
            int max_sum = nums[0];
            for (int i = 0; i < nums.length; i++) {
                if (i == 0 || last_sum < 0) {
                    current_sum = nums[i];
                }else {
                    current_sum += nums[i];
                }
                if (current_sum >= max_sum){
                    max_sum = current_sum;
                }
                last_sum = current_sum;
            }
            return max_sum;
        }
    }

    public static void main(String[] args) {
        //new一个test对象
        最大子序和 test = new 最大子序和();
        //自定义测试用例
        int nums[] = {-2,1,-3,4,-1,2,1,-5,4};
        long startTime = System.currentTimeMillis();
        //输出结果
        System.out.println(test.maxSubArray(nums));
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");

    }
}
