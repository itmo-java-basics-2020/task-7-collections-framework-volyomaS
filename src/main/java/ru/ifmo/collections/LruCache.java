package ru.ifmo.collections;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Represents LRU cache with fixed maximum capacity.
 * <p>
 * get() should return null if there is no value for a given key.
 * elements() should return number of elements in cache.
 * <p>
 * This class should not have any other public methods.
 * <p>
 * Implementing this cache in (almost) the same manner as it was implemented during the lecture will result in extra points.
 */
public class LruCache<K, V> {

    private final LinkedHashMap<K, V> values;
    private final int maxCapacity;

    public LruCache(int capacity) {
        if (capacity < 1) {
            throw new IllegalArgumentException("Capacity should be bigger than 0");
        }
        this.values = new LinkedHashMap<>(capacity, 1f, true) {
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > maxCapacity;
            }
        };
        this.maxCapacity = capacity;
    }

    public V get(K key) {
        return values.get(key);
    }

    public void put(K key, V value) {
        values.put(key, value);
    }

    public int elements() {
        return values.keySet().size();
    }
}