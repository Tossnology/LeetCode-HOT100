public class 盛最多水的容器 {
    public int maxArea(int[] height) {
        int result = 0;
        int i = 0;
        int j = height.length-1;
        result = (j-i) * Math.min(height[i],height[j]);
        int currentLower = 0;
        while (i<j){
            if (height[i]<=height[j]){
                currentLower = height[i];
                i++;
                while(height[i]<currentLower && i<j){
                    i++;
                }
                result = Math.max(result,(j-i) * Math.min(height[i],height[j]));
            }else{
                currentLower = height[j];
                j--;
                while(height[j]<currentLower && i<j){
                    j--;
                }
                result = Math.max(result,(j-i) * Math.min(height[i],height[j]));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] height = {};
        盛最多水的容器 test = new 盛最多水的容器();
        System.out.println(test.maxArea(height));
    }
}
