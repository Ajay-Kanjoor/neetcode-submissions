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
    private ArrayList<ListNode> heads;

    public ListNode reverseKGroup(ListNode head, int k) {
        heads = new ArrayList<>();  // List of Links
        int i = 0;

        while (head != null){
            ListNode reset = null;
            if ((i + 1) % k == 0) reset = head;
            if (i % k == 0) heads.add(head);
            head = head.next;
            i++;
            if (reset != null) reset.next = null;
        }
        // System.out.println(heads.size());
        // heads.forEach(e -> {
        //     System.out.println(e.val);
        // });

        // Remove uneven tail
        ListNode tail = null;
        if (i % k != 0) tail = heads.remove(heads.size() - 1);
        System.out.println(tail);

        // reverse chunks
        for (int j = 0; j < heads.size(); j++){
            heads.set(j, reverse(heads.get(j)));
        }
        // heads.forEach(e -> {
        //     System.out.println(e.val);
        // });

        // put lists together
        int j = 0;
        ListNode res = new ListNode(0);
        ListNode dummy = res;
        while (j < heads.size()){
            res.next = heads.get(j);
            while (res.next != null) res = res.next;
            j++;
        }
        res.next = tail;
        return dummy.next;
    }

    // private ListNode reverse(ListNode l, int k){
    private ListNode reverse(ListNode l){
        ListNode res = null;
        while (l != null) {
            ListNode temp = l.next;
            l.next = res;
            res = l;
            l = temp;
        }
        return res;
    }
}
