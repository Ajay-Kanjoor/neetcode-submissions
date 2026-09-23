public class Node {
    int key;
    int val;
    Node prev;
    Node next;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
        this.prev = null;
        this.next = null;
    }
}

class LRUCache {

    private HashMap<Integer, Node> cache;
    private int cap;
    private Node left;
    private Node right;


    public LRUCache(int capacity) {
        cache = new HashMap<>();
        left = new Node(0,0);
        right = new Node(0,0);
        cap = capacity;
        left.next = this.right;
        right.prev = this.left;
    }

    private void remove(Node node) {
        // Node prev = node.prev;
        // Node nxt = node.next;
        // prev.next = nxt;
        // nxt.prev = prev;

        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insert(Node node) {
        Node prev = this.right.prev;
        prev.next = node;
        node.prev = prev;
        node.next = this.right;
        this.right.prev = node; 

        // node.prev = this.right.prev;
        // node.next = this.right;
        // this.right.prev.next = node;
    }
    
    public int get(int key) {
        if (!cache.containsKey(key)) return -1;
        Node cur = cache.get(key);
        remove(cur);
        insert(cur);
        return cur.val;
    }
    
    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            remove(cache.get(key));
        } 
        Node dum = new Node(key, value);
        cache.put(key, dum);
        insert(dum);

        if (cache.size() > cap){
            Node n = left.next;
            remove(n);
            cache.remove(n.key);
        }

    }
}
