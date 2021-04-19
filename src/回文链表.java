public class 回文链表 {
    public boolean isPalindrome(ListNode head) {
        ListNode cur = head;
        int count = 0;
        ListNode last = null;

        while (cur != null) {
            count += 1;
            cur = cur.next;
        }

        cur = head;

        for (int i = 0; i < count/2; i++) {
            if (i == count/2 - 1) {
                last = cur;
            }
            cur = cur.next;
        }

        if (count % 2 == 0) {
            last.next = null;
        }

        ListNode head2 = reverseList(cur);

        for (int i = 0; i < count/2; i++) {
            if (head.val == head2.val) {
                head = head.next;
                head2 = head2.next;
            } else {
                return false;
            }
        }

        return true;
    }

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

