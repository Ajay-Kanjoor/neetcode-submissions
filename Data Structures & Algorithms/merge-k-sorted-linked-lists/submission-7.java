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
        if (lists == null || lists.length == 0) return null;

        Stack<ListNode> stack = new Stack<>();
        for (ListNode list : lists){
            stack.push(list);
        }

        while (stack.size() > 1) {
            ListNode left = stack.pop();
            ListNode right = (stack.isEmpty()) ? null : stack.pop();
            
            ListNode dummy = new ListNode(0);
            ListNode cur = dummy;
            while (left != null && right != null){
                if (left.val < right.val){
                    cur.next = left;
                    left = left.next;
                } else {
                    cur.next = right;
                    right = right.next;
                }
                cur = cur.next;
                cur.next = null;
            }
            if (left != null) cur.next = left;
            else cur.next = right;

            stack.push(dummy.next);
        }
        return stack.pop();
    }
}
