import java.util.LinkedHashMap;

class LRUCache {
    int size;
    LinkedHashMap<Integer, Integer> map;

    public LRUCache(int capacity) {
        size = capacity;
        map = new LinkedHashMap<>();
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            int value = map.remove(key);
            map.put(key, value);
            return value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            map.remove(key);
        }
        map.put(key, value);
        if (map.size() > size) {
            int lru = map.keySet().iterator().next();
            map.remove(lru);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */