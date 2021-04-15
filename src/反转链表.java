public class 反转链表 {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode result = reverseList(head.next);
        ListNode cur = result;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = head;
        return result;
    }
}
