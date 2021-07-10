package geek.beauty.sort;

import edu.princeton.cs.algs4.In;

import static com.agoms4.Utils.*;

@SuppressWarnings("rawtypes")
public class Insertion {

    public static void sort(Comparable[] a) {
        if (a == null || a.length <= 0) return;
        int N = a.length;
        for (int i = 1; i < N; i++) {
            Comparable value = a[i];
            // 后移操作
            int j = i;
            for (; j > 0 && less(value, a[j - 1]); j--) {
                a[j] = a[j - 1];
            }
            a[j] = value;
        }
    }

    public static void main(String[] args) {
        String[] a = In.readStrings();
        sort(a);
        assert isSorted(a);
        show(a);
    }
}
