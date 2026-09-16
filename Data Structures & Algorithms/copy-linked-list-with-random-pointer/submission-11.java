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
        if (head == null) {
            return null;
        }

        // Step 1: Insert copied nodes after each original node
        Node curr = head;
        while (curr != null) {
            Node copy = new Node(curr.val);
            copy.next = curr.next;
            curr.next = copy;
            curr = copy.next;
        }

        // Step 2: Copy the random pointers
        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        // Step 3: Separate the two lists
        curr = head;
        Node copyHead = head.next;

        while (curr != null) {
            Node copy = curr.next;

            curr.next = copy.next;

            if (copy.next != null) {
                copy.next = copy.next.next;
            }

            curr = curr.next;
        }

        return copyHead;
        // if (head == null) return null;

        // Node l1 = head;
        // while (l1 != null){
        //     Node l2 = new Node(l1.val);
        //     l2.next = l1.random;
        //     l1.random = l2;
        //     l1 = l1.next;
        // }

        // Node res = head.random;

        // l1 = head;
        // while (l1 != null){
        //     Node l2 = l1.random;

        //     if (l2.next != null) l2.random = l2.next.random;
        //     else l2.random = null;

        //     l1 = l1.next;
        // }

        // l1 = head;
        // while (l1 != null){
        //     Node l2 = l1.random;
        //     l1.random = l2.next;

        //     if (l1.next != null) l2.next = l1.next.random;
        //     else l2.next = null;

        //     l1 = l1.next;
        // }

        // return res;
    }
}
