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
            cur = cur.next.next;
        }

        cur = head;
        while (cur != null && cur.next != null){
            if (cur.random == null) cur.next.random = null;
            else cur.next.random = cur.random.next;
            cur = cur.next.next;
        }

        cur = head;
        Node res = head.next;
        Node resHead = res;

        while (res.next != null){
            cur.next = cur.next.next;
            res.next = res.next.next;
            cur = cur.next;
            res = res.next;
        }

        cur.next = cur.next.next;

        return resHead;
    }
}
