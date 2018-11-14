class MyHashMap {

    class Entry {
        int key;
        int value;
        Entry next;

        public Entry(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int size = 17;
    private Entry[] buckets;

    /** Initialize your data structure here. */
    public MyHashMap() {
        this.buckets = new Entry[this.size];
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int hash = key % this.size;
        if (this.buckets[hash] == null) {
            this.buckets[hash] = new Entry(key, value);
        } else {
            Entry bucket = this.buckets[hash];
            if (bucket.key == key) {
                bucket.value = value;
            } else {
                while(bucket.next != null && bucket.next.key != key) {
                    bucket = bucket.next;
                }
                if (bucket.next == null) {
                    bucket.next = new Entry(key, value);
                } else {
                    bucket.next.value = value;
                }
            }
        }
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int hash = key % this.size;
        int value = -1;
        if (this.buckets[hash] != null) {
            Entry bucket = this.buckets[hash];
            while (bucket != null && value == -1) {
                if (bucket.key == key) value = bucket.value;
                bucket = bucket.next;
            }
        }
        return value;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int hash = key % this.size;
        if (this.buckets[hash] != null) {
            Entry bucket = this.buckets[hash];
            if (bucket.key == key) {
                this.buckets[hash] = bucket.next;
            } else {
                while (bucket.next != null && bucket.next.key != key) {
                    bucket = bucket.next;
                }
                if (bucket.next != null) {
                    bucket.next = bucket.next.next;
                }
            }
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */