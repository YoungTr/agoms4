package com.agoms4.c2sorting.s4;

import static com.agoms4.Utils.exch;

/**
 * 堆排序
 */
@SuppressWarnings({"rawtypes", "unchecked"})
public class HeapSort {

    public static void sort(Comparable[] pq) {
        int N = pq.length;
        for (int k = N / 2; k >= 1; k--) {
            sink(pq, k, N);
        }
        while (N > 1) {
            exch(pq, 1, N--);
            sink(pq, 1, N);
        }
    }

    private static void sink(Comparable[] pq, int k, final int N) {
        while (2 * k <= N) {
            int j = 2 * k;
            if (j < 2 * k && less(pq, j, j + 1)) j++;
            if (!less(pq, k, j)) break;
            exch(pq, k, j);
            k = j;
        }
    }

    private static boolean less(Comparable[] pq, int j, int i) {
        return pq[j].compareTo(pq[i]) < 0;
    }
}
