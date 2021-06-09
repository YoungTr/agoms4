package com.agoms4.c2sorting.s2;

import edu.princeton.cs.algs4.In;

import static com.agoms4.Utils.*;

/**
 * 自底向上的归并排序
 */
@SuppressWarnings({"rawtypes", "DuplicatedCode", "ManualArrayCopy"})
public class MergeBU {

    public static void sort(Comparable[] a) {
        int N = a.length;
        Comparable[] aux = new Comparable[N];
        for (int sz = 1; sz < N; sz = sz + sz) {
            for (int lo = 0; lo < N - sz; lo += sz + sz) {
                merge(a, aux, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, N - 1));
            }
        }
    }

    private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
        if (lo >= hi) {
            return;
        }
        if (less(a[mid], a[mid + 1])) {
            return;
        }

        // copy a[] to aux[]
        for (int i = lo; i <= hi; i++) {
            aux[i] = a[i];
        }
        // merge aux[] to a[]
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid)                a[k] = aux[j++];
            else if (j > hi)            a[k] = aux[i++];
            else if (less(a[i], a[j]))  a[k] = aux[i++];
            else                        a[k] = aux[j++];
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
