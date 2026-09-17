/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return add(l1, l2, 0);
    }

    private ListNode add(ListNode l1, ListNode l2, int carry){
        if (l1 == null && l2 == null && carry == 0) return null;

        int v1 = (l1 == null) ? 0 : l1.val;
        int v2 = (l2 == null) ? 0 : l2.val;

        int n = v1 + v2 + carry;
        int c = n / 10;
        ListNode cur = new ListNode(n % 10);

        cur.next = add(
            (l1 == null) ? null : l1.next,
            (l2 == null) ? null : l2.next,
            c
        );
        // if (l1 == null) cur.next = add(l1, l2.next, c);
        // else if (l2 == null) cur.next = add(l1.next, l2, c);
        // else cur.next = add(l1.next, l2.next, c);
        return cur;
    }
}
