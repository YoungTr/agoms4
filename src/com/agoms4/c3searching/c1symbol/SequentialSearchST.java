package com.agoms4.c3searching.c1symbol;

import com.agoms4.c1.s3.Queue;

public class SequentialSearchST<Key, Value> {

    private Node first;
    private int size;

    private class Node {
        Key key;
        Value value;
        Node next;

        public Node(Key key, Value value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public Value get(Key key) {
        for (Node x = first; x != null; x = x.next) {
            if (x.key.equals(key)) {
                return x.value;
            }
        }
        return null;
    }

    public void put(Key key, Value value) {
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.value)) {
                x.value = value;
                return;
            }
        }
        size++;
        first = new Node(key, value, first);
    }

    public void delete(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("Argument to delete() cannot be null");
        }

        if (isEmpty()) {
            return;
        }

        if (key.equals(first.key)) {
            first = first.next;
            size--;
            return;
        }

        for (Node x = first; x != null; x = x.next) {
            if (x.next != null && key.equals(x.next.key)) {
                x.next = x.next.next;
                size--;
                return;
            }
        }
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public Iterable<Key> keys() {
        Queue<Key> keys = new Queue<>();

        for (Node node = first; node != null; node = node.next) {
            keys.enqueue(node.key);
        }

        return keys;
    }

}
