class State {
    char sign;
    private boolean loop;
    State next;

    boolean isLoop(){
        return this.loop;
    }

    void setLoop(boolean loop){
        this.loop = loop;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        State cur = this;
        while (cur != null){
            sb.append(cur.sign);
            if (cur.isLoop()){
                sb.append('*');
            }
            if (cur.next == null){
                break;
            }else {
                sb.append("->");
                cur = cur.next;
            }
        }
        return sb.toString();
    }
}

public class 正则表达式匹配 {
    public boolean isMatch(String s, String p) {
        boolean ans = false;
        State start = new State();
        State cur = start;
        //创建自动机链表
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '*'){
                continue;
            }
            cur.sign = p.charAt(i);
            if (i != p.length()-1 && i != p.length()-2 && p.charAt(i+1) == '*'){
                cur.setLoop(true);
                cur.next = new State();
                cur = cur.next;
            }
            if (i == p.length()-2 && p.charAt(i+1) == '*'){
                cur.setLoop(true);
            }
            if (i != p.length()-1 && p.charAt(i+1) != '*'){
                cur.next = new State();
                cur = cur.next;
            }
        }

        cur = start;
        System.out.println(start.toString());
        //走一遍自动机
        int flag = 0;
        int i;
        for ( i=0; i < s.length(); i++) {
            if (cur == null){
                break;
            }
            if (s.charAt(i) == cur.sign || cur.sign == '.'){
                if (cur.isLoop()){
                    flag = 1;
                }else {
                    cur = cur.next;
                }
            }else {
                if (flag == 1){
                    cur = cur.next;
                    flag = 0;
                    i--;
                }else if (cur.isLoop()){
                    cur = cur.next;
                    i--;
                }else {
                    break;
                }
            }
            if (i == s.length()-1 && flag == 1){
                cur = cur.next;
            }
        }
        System.out.println(i);
        if (cur == null && i == s.length()){
            ans = true;
        }
        return ans;
    }

    //作弊
    public boolean isMatch2(String s, String p) {
        return s.matches(p);
    }

    public static void main(String[] args) {
        //new一个test对象
        正则表达式匹配 test = new 正则表达式匹配();
        //自定义测试用例
        String s = "mississippi";
        String p = "mis*is*p*.";
        long startTime = System.currentTimeMillis();
        //输出结果

        System.out.println(test.isMatch(s,p));
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");

    }
}
