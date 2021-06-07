package com.agoms4.c2sorting.s2;

import edu.princeton.cs.algs4.In;

import static com.agoms4.Utils.*;

/**
 * 归并排序：自顶向下
 * 所需时间和 NlgN 成正比
 * 缺点：需要额外的空间和 N 成正比
 */
@SuppressWarnings("rawtypes")
public class Merge {

    public static void sort(Comparable[] a) {
        int N = a.length;
        Comparable[] aux = new Comparable[N];
        sort(a, aux, 0, N - 1);
    }

    private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {
        if (lo >= hi) return;
        int mid = lo + (hi - lo) / 2;
        sort(a, aux, lo, mid);
        sort(a, aux, mid + 1, hi);
        merge(a, aux, lo, mid, hi);

    }

    private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
        assert isSorted(a, lo, mid);
        assert isSorted(a, mid + 1, hi);

        /*
          如果 a[mid] 小于等于 a[mid+1]
          我们认为数组已经是有序的并跳过 merge() 方法
         */
        if (less(a[mid], a[mid + 1])) {
            return;
        }

        // copy to axu[]
        for (int i = lo; i <= hi; i++) {
            aux[i] = a[i];
        }
        int i = lo, j = mid + 1;
        // merge back to a[]
        for (int k = lo; k <= hi; k++) {
            if (i > mid)                    a[k] = aux[j++];
            else if (j > hi)                a[k] = aux[i++];
            else if (less(aux[i], aux[j]))  a[k] = aux[i++];
            else                            a[k] = aux[j++];
        }
        assert isSorted(a, lo, hi);
    }

    public static void main(String[] args) {
        String[] a = In.readStrings();
        sort(a);
        assert isSorted(a);
        show(a);
    }
}
