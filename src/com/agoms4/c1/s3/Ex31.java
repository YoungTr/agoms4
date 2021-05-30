package com.agoms4.c1.s3;

public class Ex31<Item> {

    private class DoubleNode {
        Item item;
        DoubleNode previous;
        DoubleNode next;
    }

    private int size;
    private DoubleNode first;
    private DoubleNode last;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void insertAtBeginner(Item item) {
        DoubleNode oldFirst = first;
        first = new DoubleNode();
        first.item = item;
        first.next = oldFirst;

        if (oldFirst != null) {
            oldFirst.previous = first;
        }

        if (isEmpty()) {
            last = first;
        }

        size++;
    }

    public void insertAtEnd(Item item) {
        DoubleNode oldLast = last;
        last = new DoubleNode();
        last.item = item;
        last.previous = oldLast;
        if (oldLast != null) {
            oldLast.next = last;
        }
        if (isEmpty()) {
            first = last;
        }

        size++;
    }

    public Item removeFromBeginning() {
        if (isEmpty()) {
            return null;
        }

        Item item = first.item;
        if (first.next != null) {
            first.next.previous = null;
        } else {
            // There is only 1 element in the list
            last = null;
        }

        first = first.next;
        size--;
        return item;
    }

    public Item removeFromEnd() {
        if (isEmpty()) {
            return null;
        }

        Item item = last.item;
        if (last.previous != null) {
            last.previous.next = null;
        } else {
            // There is only 1 element in the list
            first = null;
        }
        last = last.previous;
        size--;

        return item;
    }

}
