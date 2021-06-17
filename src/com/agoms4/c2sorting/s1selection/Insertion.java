package com.agoms4.c2sorting.s1selection;

import edu.princeton.cs.algs4.In;

import static com.agoms4.Utils.*;

/**
 * 插入排序
 * 对部分有序的数组排序是线性的
 */
@SuppressWarnings("rawtypes")
public class Insertion {

    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 1; i < N; i++) {
            // 将 a[i] 插入到 a[i-1]、a[i-2]、a[i-3]...之中
            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
                exch(a, j, j - 1);
            }
        }
    }

    public static void main(String[] args) {
        String[] a = In.readStrings();
        sort(a);
        assert isSorted(a);
        show(a);
    }
}
