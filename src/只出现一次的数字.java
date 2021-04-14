import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class 只出现一次的数字 {
    public int singleNumber(int[] nums) {
        int result = 0;

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], 2);
            }
        }

        for (Integer t : map.keySet()) {
            if (map.get(t) == 1) {
                result = t;
            }
        }

        return result;
    }
}
