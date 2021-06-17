package com.agoms4.c2sorting.s3quick;

import edu.princeton.cs.algs4.StdRandom;

import static com.agoms4.Utils.exch;

/**
 * 三向切分的快速排序
 */
@SuppressWarnings({"rawtypes", "unchecked"})
public class Quick3Way {


    public static void sort(Comparable[] a) {
        StdRandom.shuffle(a);
        sort3Way(a, 0, a.length - 1);
    }

    //a[l0...lt-1] < v = a[lt..gt] < a[gt+1...hi]
    private static void sort3Way(Comparable[] a, int lo, int hi) {
        if (lo >= hi) return;
        int lt = lo, gt = hi, i = lo + 1;
        Comparable v = a[lo];
        while (i <= gt) {
            int cmp = a[i].compareTo(v);
            // a[i] < v, a[lt] 和 a[i] 交换，lt++,i++
            if (cmp < 0) exch(a, lt++, i++);
            // a[i] > v, a[gt] 和 a[i] 交换，gt--, i++
            else if (cmp > 0) exch(a, gt--, i);
            // a[i] == v, i++
            else i++;
        }
        sort3Way(a, lo, lt - 1);
        sort3Way(a, gt + 1, hi);
    }
}
