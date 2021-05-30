package com.agoms4.c1.s3;

public class Ex32<Item> {


    private class Node {
        Item item;
        Node previous;
        Node next;
    }

    private int size;
    private Node first;
    private Node last;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public Item pop() {
        if (isEmpty()) {
            throw new RuntimeException("Steque underflow");
        }

        Item item = first.item;
        first = first.next;

        if (first != null) {
            first.previous = null;
        } else {
            last = null;
        }

        size--;

        return item;
    }

    public void push(Item item) {
        Node oldFirst = first;

        first = new Node();
        first.item = item;
        first.next = oldFirst;

        if (oldFirst != null) {
            oldFirst.previous = first;
        } else {
            last = first;
        }

        size++;
    }

    public void enqueue(Item item) {
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.previous = oldLast;

        if (oldLast != null) {
            oldLast.next = last;
        } else {
            first = last;
        }
        size--;
    }

}
