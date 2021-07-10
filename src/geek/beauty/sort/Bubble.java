package geek.beauty.sort;

import edu.princeton.cs.algs4.In;

import static com.agoms4.Utils.*;

@SuppressWarnings("rawtypes")
public class Bubble {

    public static void sort(Comparable[] a) {
        if (a == null || a.length <= 0) return;
        int N = a.length;
        for (int i = 0; i < N; i++) {
            boolean hasExch = false;
            for (int j = 0; j < N - i - 1; j++) {
                if (large(a[j], a[j + 1])) {
                    exch(a, j, j + 1);
                    hasExch = true;
                }
            }
            if (!hasExch) break;    // 如果没有发生交换，说明已经有序
        }
    }

    public static void main(String[] args) {
        String[] a = In.readStrings();
        sort(a);
        assert isSorted(a);
        show(a);
    }

}
