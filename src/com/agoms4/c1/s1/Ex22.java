package com.agoms4.c1.s1;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class Ex22 {

    public static int rank(int key, int[] a) {
        return search(0, a.length - 1, key, a, 0);
    }

    public static int search(int lo, int hi, int key, int[] a, int level) {
        if (lo > hi) {
            return -1;
        }
        for (int i = 0; i < level; i++) {
            StdOut.print(" ");
        }
        StdOut.println("lo = " + lo + ", hi = " + hi);
        int mid = lo + (hi - lo) / 2;
        if (key < a[mid]) return search(lo, mid - 1, key, a, ++level);
        if (key > a[mid]) return search(mid + 1, hi, key, a, ++level);
        return mid;
    }

    public static void main(String[] args) {
        int[] whitelist = In.readInts(args[0]);
        Arrays.sort(whitelist);
        StdOut.println("whitelist = " + Arrays.toString(whitelist));
        while (!StdIn.isEmpty()) {
            // 读取键值，如果不存在于白名单中则将其打印
            int key = StdIn.readInt();
            if (rank(key, whitelist) < 0) {
                StdOut.println(key);
            }
        }
    }

}
