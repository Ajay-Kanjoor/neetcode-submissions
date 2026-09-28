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
    // public ListNode mergeKLists(ListNode[] lists) {
    //     if (lists.length == 0) return null;

    //     for (int i = 1; i < lists.length; i++){
    //         lists[i] = merge(lists[i - 1], lists[i]);
    //     }

    //     return lists[lists.length - 1];
    // }

    // public ListNode merge(ListNode l1, ListNode l2) {
    //     ListNode head = new ListNode(0);
    //     ListNode dummy = head;

    //     while (l1 != null && l2 != null){
    //         if (l1.val <= l2.val){
    //             head.next = l1;
    //             l1 = l1.next;
    //         } else {
    //             head.next = l2;
    //             l2 = l2.next;
    //         }
    //         head = head.next;
    //     }
    //     if (l1 == null) head.next = l2;
    //     else head.next = l1;

    //     return dummy.next;
    // }




    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;

        for (int i = 1; i < lists.length; i++){
            ListNode head = new ListNode(0);
            ListNode dummy = head;

            while (lists[i] != null && lists[i - 1] != null){
                if (lists[i].val < lists[i - 1].val){
                    head.next = lists[i];
                    lists[i] = lists[i].next;
                } else {
                    head.next = lists[i - 1];
                    lists[i - 1] = lists[i - 1].next;
                }
                head = head.next;
            }
            if (lists[i] == null) head.next = lists[i - 1];
            else head.next = lists[i];

            lists[i] = dummy.next;
        }
        return lists[lists.length - 1];
    }
}
