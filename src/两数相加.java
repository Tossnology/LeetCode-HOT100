
class 两数相加 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode cursor1 = l1;
        ListNode cursor2 = l2;
        ListNode result = new ListNode(0);
        ListNode cursor3 = result;
        int sum = 0;
        while(cursor1 != null && cursor2 != null){
            cursor3.val = cursor1.val + cursor2.val + cursor3.val;
            if(cursor3.val >= 10){
                cursor3.val = cursor3.val-10;
                cursor3.next = new ListNode(1);
            }else{
                if(cursor1.next == null && cursor2.next == null){
                    cursor3.next = null;
                }else{
                    cursor3.next = new ListNode(0);
                }
            }
            cursor1 = cursor1.next;
            cursor2 = cursor2.next;
            cursor3 = cursor3.next;
        }
        cursor3 = getListNode(cursor1, cursor3);
        cursor3 = getListNode(cursor2, cursor3);
        return result;
    }

    private ListNode getListNode(ListNode cursor1, ListNode cursor3) {
        while(cursor1 != null){
            cursor3.val = cursor1.val + cursor3.val;
            if(cursor3.val >= 10){
                cursor3.val = cursor3.val-10;
                cursor3.next = new ListNode(1);
            }else{
                if(cursor1.next == null){
                    cursor3.next = null;
                }else{
                    cursor3.next = new ListNode(0);
                }
            }
            cursor1 = cursor1.next;
            cursor3 = cursor3.next;
        }
        return cursor3;
    }
}
