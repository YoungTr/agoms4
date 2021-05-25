package com.agoms4.c1.s3;

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

public class Ex28<Item> implements Iterable<Item> {

    private class Node {
        Item item;
        Node next;
    }

    private int n;
    private Node first;

    public void add(Item item) {
        if (isEmpty()) {
            first = new Node();
            first.item = item;
        } else {
            Node current = first;
            while (current.next != null) {
                current = current.next;
            }
            Node node = new Node();
            node.item = item;
            current.next = node;
        }
        n++;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    public void deleteLastNode() {
        if (!isEmpty()) {
            if (size() == 1) {
                first = null;
            } else {
                Node current = first;
//                while (current.next != null && current.next.next != null) {
//                    current = current.next;
//                }

                for (int i = 0; i < n - 2; i++) {
                    current = current.next;
                }

                current.next = null;
            }
            n--;
        }
    }

    public void delete(int k) {
        if (isEmpty() || k > size()) {
            return;
        }

        if (k == 1) {
            first = first.next;
        } else {
            Node current = first;
            int count = 1;
            while (count < k - 1) {
                current = current.next;
                count++;
            }
            current.next = current.next.next;
        }
        n--;

    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {
        Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            Item item = current.item;
            current = current.next;


            return item;
        }


    }

    public int max() {
        if (isEmpty()) {
            return 0;
        }
        int currentMaxValue = (Integer) first.item;
        return getMax(first.next, currentMaxValue);
    }

    private int getMax(Node node, int currentMaxValue) {
        if (node == null) {
            return currentMaxValue;
        }
        int currentValue = (Integer) node.item;
        if (currentValue > currentMaxValue) {
            currentMaxValue = currentValue;
        }
        return getMax(node.next, currentMaxValue);
    }

    public static void main(String[] args) {
        Ex28<Integer> linkedList = new Ex28<>();
        linkedList.add(3);
        linkedList.add(901);
        linkedList.add(2);
        linkedList.add(9);

        int maxValue = linkedList.max();
        StdOut.println("Max value: " + maxValue);
        StdOut.println("Expected: 901");
    }


}
