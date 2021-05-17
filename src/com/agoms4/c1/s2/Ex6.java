package com.agoms4.c1.s2;

import edu.princeton.cs.algs4.StdOut;

public class Ex6 {

    public static void main(String[] args) {
        String s1 = "abc";
        String t1 = "def";

        StdOut.println("Is circular Shift 1: " + isCircularShift(s1, t1) + " Expected: false");

        String s2 = "rene";
        String t2 = "nere";

        StdOut.println("Is circular Shift 2: " + isCircularShift(s2, t2) + " Expected: true");

    }

    private static boolean isCircularShift(String s, String t) {
        return s.length() == t.length() && (s + s).contains(t);
    }
}
