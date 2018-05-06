package struct.impl.sort;

/**
 * 冒泡排序
 *
 * @Author: jicheng
 * @Since: 2018年05月03日 下午1:53
 */
public class BubbleSort<E extends Comparable<E>> extends BaseSort<E> {

    @Override
    public void sort(E[] items) {
        if (isEmpty(items)) {
            return;
        }
        for (int i = 0; i < items.length; i++) {
            for (int j = items.length - 1; j > i; j--) {
                if (items[j].compareTo(items[j - 1]) < 0) {
                    swap(items, j, j - 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        BubbleSort<Integer> bubbleSort = new BubbleSort<>();
        Integer[] item = new Integer[]{23, 45, 23, 1, 34, 6767};
        bubbleSort.sort(item);
        for (Integer it : item) {
            System.out.println(it);
        }
    }
}
