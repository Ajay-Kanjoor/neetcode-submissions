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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // if (head == null) return null;
        // if (n == 1 && head.next == null) return null;
        ListNode dummy = new ListNode(0, head);
        ListNode right = head;
        ListNode left = dummy;

        // for (int i = 0; i <= n; i++){
        //     right = right.next;
        // }
        while (n > 0) {
            right = right.next;
            n--;
        }
        while (right != null) {
            left = left.next;
            right = right.next;
        }

        // for (int i = 0; right != null; i++){
        //     if (i >= n) left = left.next;
        //     right = right.next;
        // }
        left.next = left.next.next;
        return dummy.next;
    }
}
