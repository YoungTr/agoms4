package com.agoms4.c2sorting.s1selection;

import static com.agoms4.Utils.exch;
import static com.agoms4.Utils.less;

/**
 * 希尔排序的思想是使数组中任意间隔为 h 的元素都是有序的(h 有序数组)。
 */
@SuppressWarnings("rawtypes")
public class Shell {

    public static void sort(Comparable[] a) {
        int N = a.length;
        int h = 1;
        while (h < N / 3) h = 3 * h + 1;
        while (h >= 1) {
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
                    exch(a, j, j - h);
                }
            }
            h /= 3;
        }
    }
}
