import java.util.Arrays;

public class 搜索旋转排序数组 {
    //O(n)
    public int search(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target){
                return i;
            }
        }
        return -1;
    }

    //二分查找 O( log(n) )
    public int search2(int[] nums, int target) {
        int l = 0;
        int r = nums.length-1;
        int mid;
        while (l <= r){
            mid = (l + r) / 2 ;
            if (nums[mid] == target){
                return mid;
            }
            if (nums[mid] >= nums[0]){
                if (target >= nums[0]){
                    if (target < nums[mid]){
                        r = mid - 1;
                    }else {
                        l = mid + 1;
                    }
                }else {
                    l = mid + 1;
                }
            }else {
                if (target < nums[0]){
                    if (target < nums[mid]){
                        r = mid - 1;
                    }else {
                        l = mid + 1;
                    }
                }else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }
}
