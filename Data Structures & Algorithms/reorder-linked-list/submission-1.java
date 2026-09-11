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
    public void reorderList(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        } // slow now halfway thru list;

        ListNode half = slow.next; // head and half = 2 lists
        slow.next = null;

        ListNode dummy = null;
        while (half != null){ // Reverse Second half
            ListNode temp = half.next; // half, half.next
            half.next = dummy;
            dummy = half;
            half = temp;
        }

        ListNode first = head;
        ListNode second = dummy;
        while (second != null){ // Merge Halves
            ListNode temp = first.next;
            ListNode temp2 = second.next;
            first.next = second;
            second.next = temp;
            first = temp;
            second = temp2;
        }
    }
}
