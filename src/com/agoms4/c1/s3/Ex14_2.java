package com.agoms4.c1.s3;

import edu.princeton.cs.algs4.StdOut;

public class Ex14_2 {

    private String[] items;
    private int n;
    private int first;
    private int last;

    public Ex14_2(int capacity) {
        items = new String[capacity];
    }

    public void enqueue(String item) {
        if (n == items.length) {
            resize(2 * n);
        }
        if (last == items.length) {
            last = 0;
        }
        items[last++] = item;
        n++;
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
            if (n > 0 && n == items.length / 4) {
                resize(items.length / 2);
            }
            return item;
        }
    }

    public void resize(int capacity) {
        String[] temp = new String[capacity];
        for (int i = 0; i < n; i++) {
            temp[i] = items[(first + i) % items.length];
        }
        first = 0;
        last = n;
        items = temp;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    public static void main(String[] args) {
        Ex14_2 resizingArrayQueueOfStrings = new Ex14_2(3);

        resizingArrayQueueOfStrings.enqueue("1");
        resizingArrayQueueOfStrings.enqueue("2");
        resizingArrayQueueOfStrings.enqueue("3");
        resizingArrayQueueOfStrings.enqueue("Full");

        StdOut.println("Dequeue 1: " + resizingArrayQueueOfStrings.dequeue());
        StdOut.println("Expected: 1\n");

        resizingArrayQueueOfStrings.enqueue("4");
        StdOut.println("Dequeue 2: " + resizingArrayQueueOfStrings.dequeue());
        StdOut.println("Expected: 2");
    }
}
