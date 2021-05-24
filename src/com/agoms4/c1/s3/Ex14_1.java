package com.agoms4.c1.s3;

import edu.princeton.cs.algs4.StdOut;

public class Ex14_1 {
    private String[] items;
    private int n;
    private int first;
    private int last;

    public Ex14_1(int capacity) {
        items = new String[capacity];
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    public void enqueue(String item) {
        if (items.length != n) {
            if (last == items.length) {
                last = 0;
            }
            items[last++] = item;
            n++;
        }
    }

    public String dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue underflow");
        } else {
            String item = items[first];
            items[first] = null;
            first++;
            if (first == items.length) {
                first = 0;
            }
            n--;
            return item;
        }
    }

    public static void main(String[] args) {
        Ex14_1 fixedSizeArrayQueueOfStrings = new Ex14_1(3);

        fixedSizeArrayQueueOfStrings.enqueue("1");
        fixedSizeArrayQueueOfStrings.enqueue("2");
        fixedSizeArrayQueueOfStrings.enqueue("3");

        StdOut.println("Dequeue 1: " + fixedSizeArrayQueueOfStrings.dequeue());
        StdOut.println("Expected: 1\n");

        fixedSizeArrayQueueOfStrings.enqueue("4");
        StdOut.println("Dequeue 2: " + fixedSizeArrayQueueOfStrings.dequeue());
        StdOut.println("Expected: 2");
    }

}
