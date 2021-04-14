public class 汉明距离 {
    public int hammingDistance(int x, int y) {
        int result = 0;
        int t = x ^ y;
        for (int i = 0; i < 32; i++) {
            if (t>>1<<1 == t - 1) {
                result++;
            }
            t = t>>1;
        }
        return result;
    }
}
