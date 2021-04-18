//最小栈

//双向链表实现
class MinStack {

    private class Node {
        int val;
        Node next;
        Node last;
        Node lastMin;
        Node(int val) {
            this.val = val;
            this.next = null;
            this.last = null;
            this.lastMin = null;
        }
    }

    private Node bottom;
    private Node top;
    private Node min;

    /** initialize your data structure here. */
    public MinStack() {
        this.bottom = new Node(-1);
        this.top = bottom;
    }

    public void push(int val) {
        Node lastMin = null;
        boolean isMin = true;

        if (top != bottom) {
            if (min.val > val) {
                lastMin = min;
            } else {
                isMin = false;
            }
        }

        top.next = new Node(val);
        top.next.last = top;

        if (isMin) {
            min = top.next;
            min.lastMin = lastMin;
        }

        top = top.next;
    }

    public void pop() {

        if (min == top) {
            min = top.lastMin;
        }

        top = top.last;
    }

    public int top() {
        return this.top.val;
    }

    public int getMin() {
        return this.min.val;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

//单向链表实现
//class MinStack {
//
//    private class Node {
//        int val;
//        Node next;
//        Node lastMin;
//        Node(int val) {
//            this.val = val;
//            this.next = null;
//            this.lastMin = null;
//        }
//    }
//
//    private Node bottom;
//    private Node top;
//    private Node min;
//
//    /** initialize your data structure here. */
//    public MinStack() {
//        this.bottom = new Node(-1);
//        this.top = this.bottom;
//    }
//
//    public void push(int val) {
//        Node lastMin = null;
//        boolean isMin = true;
//
//        if (top != bottom) {
//            if (min.val > val) {
//                lastMin = min;
//            } else {
//                isMin = false;
//            }
//        }
//
//        top.next = new Node(val);
//
//        if (isMin) {
//            min = top.next;
//            min.lastMin = lastMin;
//        }
//
//        top = top.next;
//    }
//
//    public void pop() {
//        Node cur = bottom;
//
//        while (cur.next.next != null) {
//            cur = cur.next;
//        }
//
//        if (min == cur.next) {
//            min = cur.next.lastMin;
//        }
//
//        cur.next = null;
//        top = cur;
//    }
//
//    public int top() {
//        return this.top.val;
//    }
//
//    public int getMin() {
//        return this.min.val;
//    }
//}
//
///**
// * Your MinStack object will be instantiated and called as such:
// * MinStack obj = new MinStack();
// * obj.push(val);
// * obj.pop();
// * int param_3 = obj.top();
// * int param_4 = obj.getMin();
// */