package ru.ifmo.collections;

import java.util.*;

/**
 * Represents sorted set of unique values.
 * create() returns a SortedSet instance with natural ordering. (i.e. from smallest to largest in case of integer numbers)
 * from() is used to create a SortedSet instance with given Comparator.
 * Instances of a class can be created using only these two methods above.
 * <p>
 * This class should not be abstract and should be capable of adding/removing single/multiple elements.
 * It has two more methods: getSorted() and getReversed() which return an array of set contents in forward and reverse order respectively.
 * <p>
 * NB! This class must have only map(s) as an internal data structure(s).
 *
 * @param <T> set contents type
 */
public class SortedSet<T> extends AbstractSet<T> {

    private final TreeMap<T, Object> contents;
    private static final Object DUMMY = new Object();

    private SortedSet(Comparator<T> comparator) {
        if (comparator == null) {
            this.contents = new TreeMap<>();
        } else {
            this.contents = new TreeMap<>(comparator);
        }
    }

    public static <T> SortedSet<T> create() {
        return new SortedSet<>(null);
    }

    public static <T> SortedSet<T> from(Comparator<T> comparator) {
        return new SortedSet<>(comparator);
    }

    @Override
    public int size() {
        return contents.size();
    }

    @Override
    public Iterator<T> iterator() {
        return contents.keySet().iterator();
    }

    @Override
    public boolean add(T key) {
        return contents.put(key, DUMMY) == null;
    }

    @Override
    public boolean remove(Object key) {
        if (key == null) {
            throw new IllegalArgumentException("Key equals null");
        }
        return contents.remove(key) != null;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean result = true;
        for (Object key : c) {
            result &= (contents.remove(key) != null);
        }
        return result;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        boolean result = true;
        for (T key : c) {
            result &= (contents.put(key, DUMMY) == null);
        }
        return result;
    }

    public List<T> getSorted() {
        return new ArrayList<>(contents.keySet());
    }

    public List<T> getReversed() {
        return new ArrayList<>(contents.descendingKeySet());
    }
}
