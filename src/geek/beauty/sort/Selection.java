package geek.beauty.sort;

import edu.princeton.cs.algs4.In;

import static com.agoms4.Utils.*;

@SuppressWarnings("rawtypes")
public class Selection {

    @SuppressWarnings("DuplicatedCode")
    public static void sort(Comparable[] a) {
        if (a == null || a.length <= 0) return;
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = i + 1; j < N; j++) {
                if (less(a[j], a[min])) {
                    min = j;
                }
            }
            exch(a, min, i);
        }
    }

    public static void main(String[] args) {
        String[] a = In.readStrings();
        sort(a);
        assert isSorted(a);
        show(a);
    }
}
