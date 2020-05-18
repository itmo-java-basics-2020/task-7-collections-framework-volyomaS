package ru.ifmo.collections;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * Design a class which contains integers and returns first unique integer (in order of addition).
 * FirstUniqueTest can be used as an example.
 */
public class FirstUnique {

    private final LinkedList<Integer> keys = new LinkedList<>();
    private final HashMap<Integer, Integer> keysCount = new HashMap<>();

    public FirstUnique(int[] numbers) {
        if (numbers == null) {
            throw new IllegalArgumentException("Array of numbers shouldn't be null");
        }
        for (int number : numbers) {
            if (!keysCount.containsKey(number)) {
                keysCount.put(number, 1);
                keys.add(number);
            } else {
                keysCount.replace(number, keysCount.get(number) + 1);
            }
        }
    }

    public int showFirstUnique() {
        for (int key : keys) {
            if (keysCount.get(key) == 1) {
                return key;
            }
        }
        return -1;
    }

    public void add(int value) {
        if (!keysCount.containsKey(value)) {
            keysCount.put(value, 1);
            keys.add(value);
        } else {
            keysCount.replace(value, keysCount.get(value) + 1);
        }
    }
}
