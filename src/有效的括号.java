import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class 有效的括号 {
    static final Map<Character,Character> MAP = new HashMap<>();
    static {
        MAP.put('(',')');
        MAP.put('[',']');
        MAP.put('{','}');
        //下面三个凭空出现在左边必错，随便匹配，不是括号就行
        MAP.put(')','a');
        MAP.put(']','b');
        MAP.put('}','c');
    }

    public static void main(String[] args) {
        //new一个test对象
        有效的括号 test = new 有效的括号();
        //自定义测试用例
        String s = "([)]";
        long startTime = System.currentTimeMillis();
        //输出结果
        System.out.println(test.isValid(s));
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");

    }

    public boolean isValid(String s) {
        boolean ans = false;
        if (s.equals("")){
            ans = true;
        }else {
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < s.length(); i++) {
                if (i > 0 && !stack.isEmpty() && MAP.get(stack.peek()) == s.charAt(i)){
                    stack.pop();
                }else {
                    stack.push(s.charAt(i));
                }
            }
            if (stack.isEmpty()){
                ans = true;
            }
        }
        return ans;
    }
}
