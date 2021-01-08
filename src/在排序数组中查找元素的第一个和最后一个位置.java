public class 在排序数组中查找元素的第一个和最后一个位置 {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[2];
        ans[0] = findFirst(nums,target);
        ans[1] = findLast(nums,target);
        return ans;
    }

    int findFirst(int[] nums, int target){
        int l = 0;
        int r = nums.length - 1;
        int mid;
        int ans = -1;

        while (l <= r ){
            mid = (l + r) / 2;
            if (nums[mid] > target){
                r = mid - 1;
            }else {
                if (nums[mid] == target){
                    ans = mid;
                    r = mid - 1;
                }else {
                    l = mid + 1;
                }
            }
        }

        return ans;
    }

    int findLast(int[] nums, int target){
        int l = 0;
        int r = nums.length - 1;
        int mid;
        int ans = -1;

        while (l <= r){
            mid = (l + r) / 2;
            if (nums[mid] > target){
                r = mid - 1;
            }else {
                if (nums[mid] == target){
                    ans = mid;
                    l = mid + 1;
                }else {
                    l = mid + 1;
                }
            }
        }

        return ans;
    }
}
