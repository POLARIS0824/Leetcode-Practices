public class swap_ll_24 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            ListNode temp = cur.next;            // node 1
            ListNode temp1 = cur.next.next.next; // node 3

            cur.next = cur.next.next;            // dummy -> node 2
            cur.next.next = temp;                // node 2 -> node 1
            cur.next.next.next = temp1;          // node 1 -> node 3

            cur = cur.next.next;
        }
        return dummy.next;
    }
}
