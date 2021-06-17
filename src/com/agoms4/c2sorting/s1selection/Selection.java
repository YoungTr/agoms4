package com.agoms4.c2sorting.s1selection;

import edu.princeton.cs.algs4.In;

import static com.agoms4.Utils.*;

/**
 * 选择排序
 */
@SuppressWarnings("rawtypes")
public class Selection {

    /**
     * 首先找到数组中最小的那个元素，
     * 其次将它和数组的第一个元素交换位置，
     * 再次在剩下的元素中找到最小的元素，
     * 将它与数组的第二个元素交换位置，
     * 如此反复，直到整个数组排序
     *
     * @param a 待排序数组
     */
    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int min = i;  // 最小元素索引
            // 找出 a[i,N) 中最小元素的索引
            for (int j = i; j < N; j++) {
                if (less(a[j], a[min])) {
                    min = j;
                }
            }
            exch(a, i, min);
        }
    }

    public static void main(String[] args) {
        String[] a = In.readStrings();
        sort(a);
        assert isSorted(a);
        show(a);
    }

}









