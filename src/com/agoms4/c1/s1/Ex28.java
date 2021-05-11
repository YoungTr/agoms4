package com.agoms4.c1.s1;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class Ex28 {


    private static int[] removeDuplicates(int[] whitelist) {
        int length = whitelist.length;
        int count = 0;
        for (int i = 1; i < length; i++) {
            if (whitelist[count] != whitelist[i]) {
                whitelist[++count] = whitelist[i];
            }
        }
        int newLength = count + 1;
        int[] newWhitelist = new int[newLength];
        System.arraycopy(whitelist, 0, newWhitelist, 0, newLength);
        return newWhitelist;
    }

    public static int rank(int key, int[] a) {
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (key < a[mid]) hi = mid - 1;
            else if (key > a[mid]) lo = mid + 1;
            else return mid;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] whitelist = In.readInts(args[0]);
        Arrays.sort(whitelist);
        whitelist = removeDuplicates(whitelist);
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
