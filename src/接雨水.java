public class 接雨水 {
    public int trap(int[] height) {
        int ans = 0;

        int[] calced = new int[height.length];

        if (height.length <= 2) {
            return ans;
        }

        int slow = 0;
        while (height[slow] == 0) {
            slow++;
        }
        int fast = slow + 1;

        while (fast <= height.length - 1) {
            while (fast <= height.length - 1 && height[fast] < height[slow]) {
                if (fast == height.length - 1) {
                    slow = slow + 1;
                    fast = slow;
                }
                fast++;
            }

            int flag = slow;
            slow++;

            while (slow != fast) {
                ans += height[flag] - height[slow];
                calced[slow] = height[flag] - height[slow];
                slow++;
            }

            fast++;
        }

        //反向
        slow = height.length - 1;
        while (height[slow] == 0) {
            slow--;
        }
        fast = slow - 1;

        while (fast >= 0) {
            while (fast >= 0 && height[fast] < height[slow]) {
                if (fast == 0) {
                    slow = slow - 1;
                    fast = slow;
                }
                fast--;
            }

            int flag = slow;
            slow--;

            while (slow != fast) {
                if (calced[slow] < height[flag] - height[slow]) {
                    ans += height[flag] - height[slow] - calced[slow];
                }
                slow--;
            }

            fast--;
        }

        return ans;
    }

    public static void main(String[] args) {
        //new一个test对象
        接雨水 test = new 接雨水();
        //自定义测试用例
        int[] nums = {0,1,0,2,1,0,1,3,2,1,2,1};
        long startTime = System.currentTimeMillis();
        //输出结果
        test.trap(nums);
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");

    }
}
