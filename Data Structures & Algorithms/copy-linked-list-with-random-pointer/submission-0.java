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
        Map<Node, Node> pairs = new HashMap<>(); //Maps OG Node to Copy Node
        Node res = new Node(0);
        Node cur = res;
        Node iter = head;
        
        while (iter != null){
            cur.next = new Node (iter.val); //Builds Val
            pairs.put(iter, cur.next);   // Maps og to copy
            iter = iter.next;       // Builds next pointers
            cur = cur.next;
        }

        cur = res.next;
        iter = head;

        while (iter != null) {
            if (pairs.containsKey(iter.random)){
                cur.random = pairs.get(iter.random);
            } else {
                cur.random = null;
            }
            cur = cur.next;
            iter = iter.next;
        }

        return res.next;
    }
}
