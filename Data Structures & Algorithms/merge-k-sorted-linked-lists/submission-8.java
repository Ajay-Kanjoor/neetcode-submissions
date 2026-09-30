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

        // Stack<ListNode> stack = new Stack<>();
        // for (ListNode list : lists){
        //     stack.push(list);
        // }

        // while (stack.size() > 1) {
        //     ListNode left = stack.pop();
        //     ListNode right = (stack.isEmpty()) ? null : stack.pop();
            
        //     ListNode dummy = new ListNode(0);
        //     ListNode cur = dummy;
        //     while (left != null && right != null){
        //         if (left.val < right.val){
        //             cur.next = left;
        //             left = left.next;
        //         } else {
        //             cur.next = right;
        //             right = right.next;
        //         }
        //         cur = cur.next;
        //         cur.next = null;
        //     }
        //     if (left != null) cur.next = left;
        //     else cur.next = right;

        //     stack.push(dummy.next);
        // }
        // return stack.pop();


        while (lists.length > 1) {
            List<ListNode> mergedLists = new ArrayList<>();
            for (int i = 0; i < lists.length; i += 2){
                ListNode l1 = lists[i];
                ListNode l2 = (i + 1) < lists.length ? lists[i + 1] : null;
                mergedLists.add(merge(l1, l2));
            }
            lists = mergedLists.toArray(new ListNode[0]);
        }
        return lists[0];
    }

    private ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode();
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
        }
        if (left != null) cur.next = left;
        else cur.next = right;
        return dummy.next;
    }
}
