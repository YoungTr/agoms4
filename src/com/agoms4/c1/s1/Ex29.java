package com.agoms4.c1.s1;

import edu.princeton.cs.algs4.StdOut;

public class Ex29 {


    // Find the number of elements that are smaller than the key
    public static int rank(int key, int[] array) {
        return lessThanKey(key, array, 0, array.length - 1);
    }

    private static int lessThanKey(int key, int[] array, int low, int high) {

        StdOut.println("[" + low + "," + high + "]");

        if (low <= high) {
            int middle = low + (high - low) / 2;

            if (key > array[middle]) {
                return lessThanKey(key, array, middle + 1, high);
            } else {
                return lessThanKey(key, array, low, middle - 1);
            }
        }
        return low;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 4, 4, 5, 6, 6, 7, 7, 7, 8};

        StdOut.println("Rank: " + rank(3, array) + " Expected: 2");
        StdOut.println("Rank: " + rank(5, array) + " Expected: 4");
        StdOut.println();
    }

}
