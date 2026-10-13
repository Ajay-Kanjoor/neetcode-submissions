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

// Iteration
// Look k ahead
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0, head);
        ListNode groupPrev = dummy;
        
        while (true) {
            ListNode kth = getNext(groupPrev, k);
            if (kth == null) break;
            ListNode groupNext = kth.next;
            ////////////
            ListNode prev = groupNext;
            ListNode curr = groupPrev.next;
            while (curr != groupNext){
                ListNode tmp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = tmp;
            }

            ListNode temp = groupPrev.next;
            groupPrev.next = kth;
            groupPrev = temp;
        }
        return dummy.next;
    }

    private ListNode getNext(ListNode curr, int k) {
        while (k > 0 && curr != null){
            curr = curr.next;
            k--;
        }
        return curr;
    }

    //t O(n)
    //s O(1)
}
