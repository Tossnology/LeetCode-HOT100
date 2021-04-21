import java.util.ArrayList;
import java.util.List;

public class 子集 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();


        int mask = 1;
        for (int i = 0; i < nums.length; i++) {
            mask *= 2;
        }

        for (int i = 0; i < mask; i++) {
            int tmp = i;
            List<Integer> item = new ArrayList<>();
            for (int j = 0; j < nums.length; j++) {
                if ((tmp & 1) == 1) {
                    item.add(nums[nums.length-1-j]);
                }
                tmp = tmp >> 1;
            }
            result.add(item);
        }
        return result;
    }

    public List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> item = new ArrayList<>();

        dfs(0,nums,result,item);

        return result;
    }

    public void dfs(int cur, int[] nums, List<List<Integer>> result, List<Integer> item) {
        if (cur == nums.length) {
            result.add(new ArrayList<>(item));
            return;
        }

        item.add(nums[cur]);
        dfs(cur+1, nums, result, item);
        item.remove(item.size()-1);
        dfs(cur+1, nums, result, item);
    }

    public static void main(String[] args) {
        //new一个test对象
        子集 test = new 子集();
        //自定义测试用例
        int[] nums = {0,1,2};
        long startTime = System.currentTimeMillis();
        //输出结果
        test.subsets(nums);
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");

    }
}
