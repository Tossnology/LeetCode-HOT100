import org.omg.CORBA.MARSHAL;

import java.util.HashMap;
import java.util.Map;

public class 多数元素 {
    public int majorityElement(int[] nums) {
        int result = 0;

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.keySet().contains(nums[i])) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], map.get(nums[i])+1);
            }
        }

        for (Integer t : map.keySet()) {
            if (map.get(t) > nums.length/2) {
                result = t;
            }
        }

        return result;
    }
}
