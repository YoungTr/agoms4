package com.agoms4.c1.s3;

public class Ex30<Item> {

    private class Node {
        Item item;
        Node next;
    }

    public Node reverse(Node x) {
        Node first = x;
        Node reverse = null;
        while (first != null) {
            Node second = first.next;
            first.next = reverse;
            reverse = first;
            first = second;
        }
        return reverse;
    }

    public Node reverse2(Node first) {
        if (first == null) {
            return null;
        }
        if (first.next == null) {
            return first;
        }

        Node second = first.next;
        Node rest = reverse2(second);
        second.next = first;
        first.next = null;
        return rest;
    }

}
