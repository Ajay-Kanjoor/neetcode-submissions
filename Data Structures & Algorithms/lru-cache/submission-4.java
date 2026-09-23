class LRUCache {
    private ArrayList<int[]> cache;
    private int capacity;

    public LRUCache(int capacity) {
        this.cache = new ArrayList<>();
        this.capacity = capacity;
    }
    
    public int get(int key) {
        for (int i = 0; i < cache.size(); i++){
            if (cache.get(i)[0] == key){
                int[] t = cache.remove(i);
                cache.add(t);
                return t[1];
            }
        }
        return -1;
    }
    
    public void put(int key, int value) {
        for (int i = 0; i < cache.size(); i++){
            if (cache.get(i)[0] == key) cache.remove(i);
        }
        if (cache.size() >= capacity) cache.remove(0);
        cache.add(new int[]{key, value});
    }
}
