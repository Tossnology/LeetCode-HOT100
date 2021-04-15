import java.util.HashSet;
import java.util.Set;

public class 环形链表 {
    public boolean hasCycle(ListNode head) {
        boolean result = false;
        ListNode cur = head;
        int tmp = 0;

        Set<ListNode> set = new HashSet<>();
        while (cur != null){
            tmp = set.size();
            set.add(cur);
            if (set.size() == tmp) {
                result = true;
                break;
            }
            cur = cur.next;
        }

        return result;
    }
}
