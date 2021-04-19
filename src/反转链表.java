public class 反转链表 {
    //递归
    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
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

    //迭代
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        ListNode next;

        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        return prev;
    }
}
