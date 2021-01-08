import java.util.Arrays;

public class 下一个排列 {

    public static void main(String[] args) {
        //new一个test对象
        下一个排列 test = new 下一个排列();
        //自定义测试用例
        int[] nums = {4,2,0,2,3,2,0};
        long startTime = System.currentTimeMillis();
        //输出结果
        test.nextPermutation(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
        }
        System.out.println();
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");

    }

    public void nextPermutation(int[] nums) {
        int flag = 0;
        int tmp;
        for (int i = nums.length-1; i >= 0; i--) {
            if (i != 0 && nums[i-1] < nums[i]){
                for (int j = nums.length-1; j >= i; j--) {
                    if (nums[j] > nums[i-1]){
                        tmp = nums[j];
                        nums[j] = nums[i-1];
                        nums[i-1] = tmp;
                    }
                }
                int c = nums.length - i;
                int[] tmp2 = new int[c];
                for (int j = 0; j < c; j++) {
                    tmp2[j] = nums[i+j];
                }
                Arrays.sort(tmp2);
                for (int j = i; j < nums.length; j++) {
                    nums[j] = tmp2[j-i];
                }
                flag = 1;
                break;
            }
        }
        if (flag == 0){
            Arrays.sort(nums);
        }
    }
}
