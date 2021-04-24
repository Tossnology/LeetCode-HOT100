import java.lang.reflect.Array;
import java.util.*;

public class 组合总和 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Set<List<Integer>> ans = new HashSet<>();
        int sum = 0;
        List<Integer> tmp = new ArrayList<>();

        dfs(ans, sum, target, tmp, candidates);

        return new ArrayList<>(ans);
    }

    public void dfs(Set<List<Integer>> ans, int sum, int target, List<Integer> tmp, int[] candidates) {
        if (sum == target) {
            List<Integer> sorted = new ArrayList<>(tmp);
            Collections.sort(sorted);
            ans.add(sorted);
            return;
        }

        for (int i = 0; i < candidates.length; i++) {
            tmp.add(candidates[i]);
            sum += candidates[i];
            if (sum <= target) {
                dfs(ans, sum, target, tmp, candidates);
            }
            sum -= candidates[i];
            tmp.remove(tmp.size() - 1);
        }
    }

    public static void main(String[] args) {
        //new一个test对象
        组合总和 test = new 组合总和();
        //自定义测试用例
        int[] candidates = {2,3,5};
        int target = 8;
        long startTime = System.currentTimeMillis();
        //输出结果
        test.combinationSum(candidates, target);
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");

    }
}
