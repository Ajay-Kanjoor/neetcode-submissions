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
        Map<Node, Node> map = new HashMap<>(); //Old, New
        Node cur = head;
        map.put(null, null);

        while (cur != null){
            if (!map.containsKey(cur)) {
                map.put(cur, new Node(0));
            } 
            Node copy = map.get(cur);
            copy.val = cur.val;

            if (!map.containsKey(cur.next)){
                map.put(cur.next, new Node(0));
            } 
            copy.next = map.get(cur.next);

            if (!map.containsKey(cur.random)){
                map.put(cur.random, new Node(0));
            } 
            copy.random = map.get(cur.random);

            cur = cur.next;
        }
        return map.get(head);
    }
}
