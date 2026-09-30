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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);

        for (ListNode list : lists){
            if (list != null) minHeap.offer(list);
        }

        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;

        while (!minHeap.isEmpty()) {
            cur.next = minHeap.poll();
            cur = cur.next;
            if (cur.next != null) minHeap.offer(cur.next);
            cur.next = null;
        }
        return dummy.next;
    }
}
