import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

class BirthDate {
    private int day;
    private int month;
    private int year;

    public BirthDate(int d, int m, int y) {
        day = d;
        month = m;
        year = y;
    }
    // 省略get,set方法………
}

public class Test {
    public static void main(String args[]) {
        String s = "abcde";
        System.out.println(s.substring(0,1));
}

    public void change(int i) {
        i = 1234;
    }
}