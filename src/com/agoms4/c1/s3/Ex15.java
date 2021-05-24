package com.agoms4.c1.s3;

import edu.princeton.cs.algs4.StdOut;

public class Ex15 {
    private static void printItems(Queue<String> queue, int k) {
        int count = 0;

        for (String item : queue) {
            count++;

            if (count >= k) {
                StdOut.println(item);
            }
        }
    }

    // Parameters example: 3 "A B C D E F"
    public static void main(String[] args) {
        int k = Integer.parseInt(args[0]);

        String input = args[1];
        String[] stringsInput = input.split(" ");

        Queue<String> queue = new Queue<>();

        for (String string : stringsInput) {
            queue.enqueue(string);
        }

        int size = queue.getSize();

        for (int i = 0; i < size - k; i++) {
            queue.dequeue();
        }
        StdOut.println(queue.dequeue());
    }

}
