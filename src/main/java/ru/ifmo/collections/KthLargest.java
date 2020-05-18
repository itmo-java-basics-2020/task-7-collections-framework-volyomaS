package ru.ifmo.collections;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Design a class to find the kth largest element in a stream. k is from 1 to numbers.length.
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 * <p>
 * Constructor accepts an integer k and an integer array numbers, which contains initial elements from the stream.
 * For each call to the method KthLargest.add(), return the element representing the kth largest element in the stream.
 */
public class KthLargest {

    private final PriorityQueue<Integer> values;
    private final int k;

    public KthLargest(int k, int[] numbers) {
        if (numbers == null) {
            throw new IllegalArgumentException("Array of numbers shouldn't be null");
        }
        this.values = new PriorityQueue<>(Collections.reverseOrder());
        this.k = k;
        for (int number : numbers) {
            values.add(number);
        }
    }

    public int add(int val) {
        values.add(val);
        PriorityQueue<Integer> temp = new PriorityQueue<>(values);
        for (int i = 0; i < k - 1; i++) {
            temp.poll();
        }
        return temp.peek();
    }
}