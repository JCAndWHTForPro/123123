package struct.impl.sort;

import java.util.Random;

/**
 * @Author: jicheng
 * @Since: 2018年05月03日 下午7:43
 */
public class QuickSort<E extends Comparable<E>> extends BaseSort<E> {
    @Override
    protected void sort(E[] items) {
        if (isEmpty(items)) {
            return;
        }
        sort3(items, 0, items.length - 1);

    }

    /**
     * 初级快排
     *
     * @param items
     * @param begin
     * @param end
     */
    private void sort(E[] items, int begin, int end) {
        if (begin >= end) {
            return;
        }
        E flag = items[begin];
        int mid = begin;
        for (int i = begin + 1; i <= end; i++) {
            if (items[i].compareTo(flag) < 0) {
                swap(items, mid + 1, i);
                mid++;
            }
        }
        swap(items, mid, begin);
        sort(items, begin, mid - 1);
        sort(items, mid + 1, end);
    }

    /**
     * 加速一般效率的快排
     *
     * @param items
     * @param begin
     * @param end
     */
    private void sort2(E[] items, int begin, int end) {
        if (begin - end<=15) {
            InsertSort<E> insertSort = new InsertSort<>();
            insertSort.sort(items);
            return;
        }
        E flag = items[begin];
        int b = begin + 1;
        int e = end;
        while (b <= e) {
            while (b < items.length && items[b].compareTo(flag) < 0) {
                b++;
            }
            while (e >= 0 && items[e].compareTo(flag) > 0) {
                e--;
            }
            if (b <= e) {
                swap(items, b, e);
                b++;
                e--;
            }

        }
        swap(items, begin, e);

        sort2(items, begin, e - 1);
        sort2(items, e + 1, end);

    }

    /**
     * 三路快速排序算法（快排最终形象）
     *
     * @param items
     * @param begin
     * @param end
     */
    private void sort3(E[] items, int begin, int end) {
        if (begin - end<=15) {
            InsertSort<E> insertSort = new InsertSort<>();
            insertSort.sort(items);
            return;
        }
        E flag = items[begin];
        int lt = begin;
        int eq = begin + 1;
        int gt = end + 1;
        while (eq < gt) {
            if (items[eq].compareTo(flag) < 0) {
                swap(items, eq, lt + 1);
                lt++;
                eq++;
            } else if (items[eq].compareTo(flag) > 0) {
                swap(items, eq, gt - 1);
                gt--;
            } else {
                eq++;
            }
        }
        swap(items, begin, lt);
        sort3(items, begin, lt - 1);
        sort3(items, lt + 1, end);


    }

    public static void main(String[] args) {
        Integer[] items = new Integer[100000];
        Random random = new Random(37);
        for (int i = 0; i < 100000; i++) {
            int nextInt = random.nextInt(10);
            items[i] = nextInt;
        }

        QuickSort<Integer> quickSort = new QuickSort<>();
        long begin = System.nanoTime();
        quickSort.sort(items);
        long end = System.nanoTime();
        System.out.println((end - begin) / 1000000000.0);
        for(Integer it : items){
            System.out.println(it);
        }
    }
}
