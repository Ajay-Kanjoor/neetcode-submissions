/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;

        Node cur = head;
        while (cur != null){
            Node copy = new Node(cur.val);
            copy.next = cur.next;
            cur.next = copy;
            cur = copy.next;
        }

        cur = head;
        while (cur != null){
            if (cur.random != null) cur.next.random = cur.random.next;
            cur = cur.next.next;
        }

        cur = head;
        Node res = head.next;
        // Node curRes = res;

        while (cur != null){
            Node l2 = cur.next;
            cur.next = l2.next;
            if (l2.next != null) l2.next = l2.next.next;
            cur = cur.next;

            // cur.next = cur.next.next;
            // if (curRes.next != null) curRes.next = curRes.next.next;
            // cur = cur.next;
            // curRes = curRes.next;
        }

        return res;
    }
}
