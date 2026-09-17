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
        ListNode res = new ListNode(0);
        ListNode l3 = res;
        int remainder = 0;

        while (l1 != null || l2 != null){

            if (l1 == null) {
                l1 = new ListNode(0);
            } else if (l2 == null) {
                l2 = new ListNode(0);
            }

            int n = l1.val + l2.val + remainder;
            l3.next = new ListNode(n % 10);
            remainder = n / 10;

            l1 = l1.next;
            l2 = l2.next;
            l3 = l3.next;
        }
        if (remainder != 0) l3.next = new ListNode(remainder);

        return res.next;
    }
}
