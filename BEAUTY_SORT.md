## 排序

### 排序

![](./pics/sort1.png)

### 选择排序

1. 首先找到数组中最小的元素，将它和数组中第一个元素交换位置
2. 在剩下的元素中找到最小的元素，将它与数组的第二个元素交换位置
3. 如此反复，直到将整个数组排序

```java
public class Selection {
    public static void sort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int min = i;
            for (int j = i + 1; j < a.lenght; j++) {
                if (a[j] < a[min]) {
                    min = j;
                }
            }
            exch(a, i, min);
        }
    }
}
```

该算法将第 i 小的元素放到 a[i] 之中。数组的第 i 个位置的左边是 i 个最小的元素且他们不会再被访问。

### 插入排序

与选择排序一样，当前索引左边所有元素都是有序的，但它们的最终位置还不确定，为了给更小的元素腾出空间，他们可能会被移动。但是当索引到达数组的右端时，数组排序就完成了。

```java
public class Insertion {
    public void sort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            for (int j = i; j > 0 && a[j] < a[j - 1]; j--) {
                exch(a, j, j - 1);
            }
        }
    }

    // 优化，将较大的元素右移一位
    public void sort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int curr = a[i];
            int j = i;
            for (; j > 0 && a[j - 1] > a[j]; j--) {
                a[j] = a[j - 1];
            }
            a[j] = curr;
        }
    }

    // 哨兵，先找出最小的元素并将它置于数组的最左边
    // 这样就可以去掉内循环的判断条件 j > 0
    public void sort(int[] a) {
        int min = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] < a[min]) {
                min = i;
            }
        }
        exch(a, 0, min);

        for (int j = 1; j < a.length; j++) {
            int curr = a[j];
            int k = j;
            for (; a[k] < a[k - 1]; k--) {
                a[k] = a[k - 1];
            }
            a[k] = curr;
        }
    }
}
```

插入排序对于部分有序的数组十分高效。

### 归并排序

将两个有序的数组归并成一个更大的有序数组。

要将一个数组排序，可以先（递归地）将它分成两半分别排序，然后将结果归并起来。

时间复杂度 NlogN，空间复杂度 N

merge(a, lo, mid, hi) 将子数组 a[lo...mid] 和 a[mid+1...hi] 归并成一个有序的数组并将结果存放在a[lo...hi]中。

```java
public class Merge {


    public static void merge(int[] a, int lo, int mid, int hi) {
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }
        for (int k = lo; k <= hi; k++) {
            if (i > mid) a[k] = aux[j++];
            else if (j > hi) a[k] = aux[i++];
            else if (a[j] < a[i]) a[k] = aux[j++];
            else a[k] = aux[i++];
        }
    }
}
```

该方法先将所有的元素复制到 aux[] 中，然后再归并回 a[] 中。方法在归并时（第二个 for 循环）进行了 4
个判断：左半边用尽（取右半边的元素）、右半边用尽（取左半边）、右半边的当前元素小于左半边的当前元素（取右半边）、右半边的当前元素大于等于左半边的当前元素（取左半边的元素）。

#### 自顶向下的归并排序

```java
import geek.beauty.sort.Insertion;

public class Merge {

    private static int[] aux;

    public static void sort(int[] a) {
        aux = new int[a.length];
        sort(a, 0, a.length - 1);
    }

    private static void sort(int[] a, int lo, int hi) {
        if (hi <= lo) return;
        // 优化点
        // 1. 使用插入排序处理小规模的子数组（比如长度小于 15）一般可以将归并排序的运行时间缩短 10% ~ 15%。
        if (hi - lo <= 15) {
            Insertion.sort(a, lo, hi);
            return;
        }
        int mid = lo + (hi - lo) / 2;
        sort(a, lo, mid);           // 将左半边排序
        sort(a, mid + 1, hi);       // 将右半边排序
        // 优化点
        // 2. 可以增加一个判断条件，如果 a[mid] 小于等于 a[mid + 1]，我们就认为数组已经是有序的并跳过merge()方法。
        if (a[mid] > a[mid + 1])
            merge(a, lo, mid, hi);  // 归并结果
    }
}
```

归并排序所需的时间和 NlogN 成正比，可以处理数百万甚至更大规模的数组，这是插入排序或者选择排序做不到的。 主要缺点是辅助数组所使用的额外空间和 N 的大小成正比。

### 自底向上的归并排序

先归并那些微型数组，然后再成对归并得到的子数组，如此这般，直到将整个数组归并在一起。

首先进行的是两两归并（把每个元素想象成一个大小为1的数组），然后是四四归并（将两个大小为2的数组归并成一个有4个元素的数组），然后是八八的归并，一直下去。

```java
public class MergeBu {
    private static int[] aux;

    public static void sort(int[] a) {
        int N = a.length;
        aux = new int[N];
        // 子数组的大小 sz 初始值为1，每次加倍
        // sz 表示先 1 1 归并
        // 然后 2 2 归并
        // 再   4 4 归并
        for (int sz = 1; sz < N; sz = sz + sz) {
            // 每次归并先从 0 位置开始
            // 下一个归并的区间开始的位置是 lo+=sz+sz
            for (int lo = 0; lo < N - sz; lo += sz + sz) {
                // 最后一次归并的第二个数组可能比第一个子数组要小
                merge(lo, lo + sz - 1, Math.min(lo + sz + sz - 1, N - 1));
            }
        }
    }
}
```