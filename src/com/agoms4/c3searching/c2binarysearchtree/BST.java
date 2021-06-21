package com.agoms4.c3searching.c2binarysearchtree;

public class BST<Key extends Comparable<Key>, Vale> {

    private Node root;

    private class Node {
        private Key key;
        private Vale vale;
        private Node left;
        private Node right;
        private int N;

        public Node(Key key, Vale vale, int n) {
            this.key = key;
            this.vale = vale;
            N = n;
        }
    }

    public int size() {
        return size(root);
    }

    private int size(Node x) {
        if (x == null) return 0;
        else return x.N;
    }

    private Vale get(Key key) {
        return get(root, key);
    }

    private Vale get(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0)        return get(x.left, key);
        else if (cmp > 0)   return get(x.right, key);
                            return x.vale;
    }

    public void put(Key key, Vale vale) {
        root = put(root, key, vale);
    }

    private Node put(Node x, Key key, Vale vale) {
        if (x == null) return new Node(key, vale, 1);
        int cmp = key.compareTo(x.key);
        if (cmp < 0)        x.left = put(x.left, key, vale);
        else if (cmp > 0)   x.right = put(x.right, key, vale);
        else                x.vale = vale;
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    public Key max() {
        return max(root).key;
    }

    private Node max(Node x) {
        if (x.right == null) return x;
        return max(x.right);
    }

    public Key min() {
        return min(root).key;
    }

    private Node min(Node x) {
        if (x.left == null) return x;
        return min(x.left);
    }

    public Key floor(Key key) {
        Node x = floor(root, key);
        if (x == null) return null;
        return x.key;
    }

    private Node floor(Node x, Key key) {
        if (x == null)  return null;
        int cmp = key.compareTo(x.key);
        if (cmp == 0)   return x;
        if (cmp < 0)    return floor(x.left, key);
        Node t = floor(x.right, key);
        if (t != null)  return t;
        else            return x;
    }

}
