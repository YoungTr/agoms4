package com.agoms4.c1.s3;

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.StringJoiner;

public class Ex20<Item> implements Iterable<Item> {

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

    public static void main(String[] args) {
        Ex20<Integer> linkedList = new Ex20<>();
        linkedList.add(0);
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);

        StdOut.println("Before removing second node");

        StringJoiner listBeforeRemove = new StringJoiner(" ");
        for (int number : linkedList) {
            listBeforeRemove.add(String.valueOf(number));
        }

        StdOut.println(listBeforeRemove.toString());
        StdOut.println("Expected: 0 1 2 3");

        linkedList.delete(1);

        StdOut.println("\nAfter removing second node");
        StringJoiner listAfterRemove = new StringJoiner(" ");
        for (int number : linkedList) {
            listAfterRemove.add(String.valueOf(number));
        }

        StdOut.println(listAfterRemove.toString());
        StdOut.println("Expected: 1 2 3");
    }


}
