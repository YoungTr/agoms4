package com.agoms4.c3searching.c1symbol;

@SuppressWarnings("unchecked")
public class BinarySearchST<Key extends Comparable<Key>, Value> {

    private Key[] keys;
    private Value[] values;

    private int N;

    public BinarySearchST(int capacity) {
        this.keys = (Key[]) new Comparable[capacity];
        this.values = (Value[]) new Object[capacity];
    }

    public Value get(Key key) {
        if (isEmpty()) return null;
        int rank = rank(key);
        if (rank < N && keys[rank].compareTo(key) == 0) return values[rank];
        else return null;
    }

    public int rank(Key key) {
        int lo = 0, hi = N - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int cmp = key.compareTo(keys[mid]);
            if (cmp < 0) hi = mid - 1;
            else if (cmp > 0) lo = mid + 1;
            else return mid;
        }
        return lo;
    }

    public void put(Key key, Value value) {
        int rank = rank(key);
        if (rank < N && keys[rank].compareTo(key) == 0) {
            values[rank] = value;
            return;
        }

        for (int i = N; i > rank; i--) {
            keys[i] = keys[i - 1];
            values[i] = values[i - 1];
        }
        keys[rank] = key;
        values[rank] = value;
        N++;
    }

    public void delete(Key key) {

        if (isEmpty() || !contains(key)) {
            return;
        }

        int rank = rank(key);

        for (int i = rank; i < N - 1; i++) {
            keys[i] = keys[i + 1];
            values[i] = values[i + 1];
        }
        keys[N - 1] = null;
        values[N - 1] = null;
        N--;
    }

    public Key min() {
        return keys[0];
    }

    public Key max() {
        return keys[N - 1];
    }


    public boolean contains(Key key) {
        return get(key) != null;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public static void main(String[] args) {
        BinarySearchST<Integer, String> st = new BinarySearchST<>(10);
        for (int i = 0; i < 10; i++) {
            st.put(10 - i, "value: " + i);
        }
        System.out.println(st.size());
        System.out.println(st.max());
        System.out.println(st.min());
    }
}
