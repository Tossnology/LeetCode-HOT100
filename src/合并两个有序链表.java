public class 合并两个有序链表 {
    public static void main(String[] args) {
        //new一个test对象
        合并两个有序链表 test = new 合并两个有序链表();
        //自定义测试用例
        ListNode l1 = new ListNode(new int[]{-2, 5});
        ListNode l2 = new ListNode(new int[]{-9, -6, -3, -1, 1, 6});
        System.out.println(l1.toString());
        System.out.println(l2.toString());
        long startTime = System.currentTimeMillis();
        //输出结果
        System.out.println(test.mergeTwoLists(l1,l2).toString());
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");

    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null){
            return null;
        }else if (l1 == null){
            return l2;
        }else if (l2 == null){
            return l1;
        }
        ListNode head1 = l1.val <= l2.val ? l1 : l2;
        ListNode pre1 = head1;
        ListNode cur1 = head1;
        ListNode pre2;
        ListNode head2 = l1.val > l2.val ? l1 : l2;
        ListNode cur2 = head2;

        while (cur1 != null && cur2 != null){
            while (cur1 != null && cur1.val <= cur2.val){
                pre1 = cur1;
                cur1 = cur1.next;
            }
            if (cur2.next != null && cur1 != null){
                do {
                    pre2 = cur2;
                    cur2 = cur2.next;
                } while (cur1.val > cur2.val);
                pre1.next = head2;
                pre2.next = cur1;
                pre1 = cur1;
                head2 = cur2;
            }else if (cur2.next == null){
                cur2.next = pre1.next;
                pre1.next = cur2;
                break;
            }else{
                pre1.next = cur2;
                break;
            }
        }
        return head1;
    }
}
