import java.util.ArrayList;
import java.util.Collections;

public class 合并K个升序链表 {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode();
        ListNode cur;
        ArrayList<Integer> vals = new ArrayList<>();
        for (int i = 0; i < lists.length; i++) {
            cur = lists[i];
            while (cur != null){
                vals.add(cur.val);
                cur = cur.next;
            }
        }
        if (vals.size() == 0){
            return  head;
        }
        Collections.sort(vals);
        cur = head;
        for (int i = 0; i < vals.size(); i++) {
            cur.val = vals.get(i);
            if (i != vals.size()-1){
                cur.next = new ListNode();
                cur = cur.next;
            }
        }
        return head;
    }


}
