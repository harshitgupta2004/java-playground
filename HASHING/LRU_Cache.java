// TC = O(1); SC = O(n), we need to store n elements in the cache

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Set;

public class LRU_Cache {
    Set<Integer> cache;
    int capacity;

    public LRU_Cache(int capacity) {
        this.cache = new LinkedHashSet<Integer>(capacity);
        this.capacity = capacity;
    }

    public boolean get(int key) {
        if (!cache.contains(key)) {
            return false;
        }
        cache.remove(key);
        cache.add(key);
        return true;
    }

    public void refer(int key) {
        if (get(key) == false) {
            put(key);
        }
    }

    public void display() {
        LinkedList<Integer> list = new LinkedList<>(cache);

        Iterator<Integer> itr = list.descendingIterator();

        while (itr.hasNext()) {
            System.out.println(itr.next() + " ");
        }
    }

    public void put(int key) {
        if (cache.size() == capacity) {
            int firstKey = cache.iterator().next();
            cache.remove(firstKey);
        }

        cache.add(key);
    }

    public static void main(String args[]) {
        LRU_Cache ca = new LRU_Cache(4);
        ca.refer(1);
        ca.refer(2);
        ca.refer(3);
        ca.refer(1);
        ca.refer(4);
        ca.refer(5);
        ca.display();
    }
}
