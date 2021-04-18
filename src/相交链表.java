public class 相交链表 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int numA = 0;
        int numB = 0;
        int diff = 0;
        ListNode curA = headA;
        ListNode curB = headB;

        while (curA != null) {
            numA++;
            curA = curA.next;
        }
        while (curB != null) {
            numB++;
            curB = curB.next;
        }

        if (numA > numB) {
            diff = numA - numB;
            return walk(headA, headB, diff);
        } else {
            diff = numB - numA;
            return walk(headB, headA, diff);
        }
    }

    public ListNode walk(ListNode first, ListNode second, int diff) {
        ListNode cur1 = first;
        ListNode cur2 = second;

        for (int i = 0; i < diff; i++) {
            cur1 = cur1.next;
        }

        while (cur1 != null) {
            if (cur1 == cur2) {
                return cur1;
            }
            cur1 = cur1.next;
            cur2 = cur2.next;
        }

        return null;
    }
}
