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