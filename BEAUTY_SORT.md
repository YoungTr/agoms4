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