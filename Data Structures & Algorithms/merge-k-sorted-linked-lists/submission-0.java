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
        List<Integer> nodes = new ArrayList<>();
        for (ListNode ls : lists){
            while (ls != null){
                nodes.add(ls.val);
                ls = ls.next;
            }
        }
        Collections.sort(nodes);
        
        ListNode res = new ListNode();
        ListNode dummy = res;
        for (int i = 0; i < nodes.size(); i++){
            res.next = new ListNode(nodes.get(i));
            res = res.next;
        }
        return dummy.next;
    }
}
