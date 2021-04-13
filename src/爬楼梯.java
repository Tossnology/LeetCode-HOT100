import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class 爬楼梯 {
    public int climbStairs(int n) {
        if (n == 1){
            return 1;
        }
        if (n == 2){
            return 2;
        }
        int[] a = {1,2,0};
        for (int i = 2; i < n; i++) {
            a[2] = a[0] + a[1];
            a[0] = a[1];
            a[1] = a[2];
        }
        return a[2];
    }
}
