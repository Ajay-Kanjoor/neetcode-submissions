class LRUCache {

    HashMap<Integer, Integer> pairs;
    LinkedList<Integer> keys;
    int max;

    public LRUCache(int capacity) {
        pairs = new HashMap<>();
        keys = new LinkedList<>();
        max = capacity;
    }
    
    public int get(int key) {
        if (!pairs.containsKey(key)) return -1;
        keys.remove((Integer)key);
        keys.add(key);
        return pairs.get(key);
    }
    
    public void put(int key, int value) {
        if (pairs.containsKey(key)) {
            keys.remove((Integer)key);
        } else if (keys.size() >= max) {
            int least = keys.removeFirst();
            pairs.remove(least);
        }
        pairs.put(key, value);
        keys.add(key);
    }
}
