import java.util.ArrayList;
import java.util.List;

public class 全排列 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        boolean[] used = new boolean[nums.length];
        List<Integer> tmp = new ArrayList<>();

        dfs(ans, nums, used, tmp);

        return ans;
    }

    public void dfs(List<List<Integer>> ans, int[] nums, boolean[] used, List<Integer> tmp) {
        if(tmp.size() == nums.length) {
            ans.add(new ArrayList<>(tmp));
            return;
        }

        for(int i = 0;i < nums.length;i++) {
            if(!used[i]) {
                tmp.add(nums[i]);
                used[i] = true;
                dfs(ans, nums, used, tmp);
                used[i] = false;
                tmp.remove(tmp.size()-1);
            }
        }

    }
}
