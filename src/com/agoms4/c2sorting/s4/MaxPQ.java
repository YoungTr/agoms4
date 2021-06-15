package com.agoms4.c2sorting.s4;

@SuppressWarnings("unchecked")
public class MaxPQ<Key extends Comparable<Key>> {

    private Key[] pq;   // 基于堆的完全二叉树
    private int N = 0;  // 存储于 pq[1...N] 中，pq[0] 没有使用

    public MaxPQ(int maxN) {
        pq = (Key[]) new Comparable[maxN + 1];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void insert(Key v) {
        pq[++N] = v;
        swim(N);
    }

    public Key delMax() {
        Key max = pq[1];    // 从根节点得到最大元素
        exch(1, N--);     // 和其最后一个节点交换
        pq[N + 1] = null;
        sink(1);
        return max;
    }


    private void swim(int k) {
        while (k > 1 && less(k / 2, k)) {
            // 如果当前节点大于父节点，当前节点与父节点交换
            exch(k / 2, k);
            k = k / 2;
        }
    }

    private void sink(int k) {
        while (2 * k <= N) {
            int j = 2 * k;
            if (j < N && less(j, j + 1)) j++;   // 找出子节点较大的那个
            if (!less(k, j)) break;     // 如果该节点 >= 子节点，结束
            exch(k, j);
            k = j;
        }
    }

    private void exch(int i, int j) {
        Key t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }

    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

}
