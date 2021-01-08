import java.util.HashMap;
import java.util.Map;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    ListNode(int[] vals){
        ListNode cur = this;
        for (int i = 0; i < vals.length; i++) {
            cur.val = vals[i];
            if (i!=vals.length-1){
                cur.next = new ListNode();
                cur = cur.next;
            }
        }
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        ListNode cur = this;
        while (cur != null){
            sb.append(cur.val);
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

public class 删除链表的倒数第N个节点 {
    //单指针+Map
    public ListNode removeNthFromEnd(ListNode head, int n) {
        Map<Integer,ListNode> map = new HashMap<>();
        int size = 0;
        ListNode cur = head;
        while (cur != null){
            map.put(size,cur);
            size++;
            if (cur.next == null){
                if (size == n){
                    cur = head;
                    head = head.next;
                    cur.next = null;
                }else {
                    map.get(size-n-1).next = map.get(size-n).next;
                    map.get(size-n).next = null;
                }
                break;
            }else {
                cur = cur.next;
            }
        }
        return head;
    }

    //快慢指针
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode pre = new ListNode(-1,head);
        ListNode fast = pre;
        ListNode slow = pre;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while (fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        head = pre.next;
        return head;
    }
}

