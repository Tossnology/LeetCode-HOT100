import java.util.Stack;

class Item {
    char val;
    int index;

    public Item(char val, int index) {
        this.val = val;
        this.index = index;
    }
}

public class 最长有效括号 {
    public int longestValidParentheses(String s) {
        int ans = 0;
        Stack<Item> stack = new Stack<>();
        stack.push(new Item('s',-1));
        for (int i = 0; i < s.length(); i++) {
            if (stack.isEmpty()){
                stack.push(new Item(s.charAt(i), i));
                continue;
            }
            if (stack.peek().val == '(' && s.charAt(i) == ')'){
                stack.pop();
            }else {
                stack.push(new Item(s.charAt(i), i));
            }
        }
        stack.push(new Item('e',s.length()));
        if (stack.get(0).val == 'e') {
            ans = s.length();
        } else {
            int tmp;
            for (int i = 1; i < stack.size(); i++) {
                tmp = stack.get(i).index - stack.get(i-1).index - 1;
                ans = tmp > ans ? tmp : ans;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        //new一个test对象
        最长有效括号 test = new 最长有效括号();
        //自定义测试用例
        String s = ")()())";
        long startTime = System.currentTimeMillis();
        //输出结果
        System.out.println(test.longestValidParentheses(s));
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");

    }
}
