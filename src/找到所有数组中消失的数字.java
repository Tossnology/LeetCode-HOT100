import java.util.ArrayList;
import java.util.List;

public class 找到所有数组中消失的数字 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int j = (nums[i]-1)%nums.length;
            nums[j] += nums.length;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= nums.length) {
                result.add(i);
            }
        }

        return result;
    }
}
