import java.util.*;

public class 括号生成 {
    public static void main(String[] args) {
        //new一个test对象

        //自定义测试用例

        long startTime = System.currentTimeMillis();
        //输出结果

        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");

    }

    public List<String> generateParenthesis(int n) {
        Set<String> tmp = new HashSet<>();
        if (n != 0) {
            if (n == 1){
                tmp.add("()");
            }else {
                List<String> last = generateParenthesis(n-1);
                for (String l : last) {
                    tmp.add("()" + l);
                    tmp.add(l + "()");
                    tmp.add("(" + l + ")");
                    for (int i = 0; i < l.length(); i++) {
                        if (l.charAt(i) == '('){
                            tmp.add(l.substring(0,i+1) + "()" +l.substring(i+1));
                        }
                    }
                }
            }
        }
        return new ArrayList<>(tmp);
    }
}
