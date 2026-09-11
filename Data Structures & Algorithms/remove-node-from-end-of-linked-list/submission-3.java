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
        int length = 0;
        ListNode iter = head;
        while (iter != null){
            length++;
            iter = iter.next;
        }

        int j = length - n;
        if (j == 0) return head.next;

        iter = head;
        for (int i = 0; i < j; i++){
            if (i + 1 == j) {
                iter.next = iter.next.next;
                break;
            }
            iter = iter.next;
        }
        return head;

        //T O(n)
        //S O(1)
    }
}
