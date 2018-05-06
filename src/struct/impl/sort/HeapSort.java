package struct.impl.sort;

/**
 * 堆排序
 * @Author: jicheng
 * @Since: 2018年05月04日 上午10:25
 */
public class HeapSort<E extends Comparable<E>> extends BaseSort<E> {

    /**
     * 带标志位的下沉操作
     *
     * @param items
     * @param lastIndex
     * @param index
     */
    private void shiftDown(E[] items, int lastIndex, int index) {
        if (index < 0 || index > lastIndex) {
            throw new IllegalArgumentException("range is null");
        }
        int currentIndex = index;
        for (int i = index * 2 + 1; i <= lastIndex; i = i * 2 + 1) {
            if (i + 1 <= lastIndex && items[i + 1].compareTo(items[i]) > 0) {
                i++;
            }
            if (items[i].compareTo(items[currentIndex]) > 0) {
                swap(items, i, currentIndex);
                currentIndex = i;
            } else {
                break;
            }

        }
    }

    @Override
    protected void sort(E[] items) {
        if (isEmpty(items)) {
            return;
        }
        for (int i = (items.length - 2) / 2; i >= 0; i--) {
            shiftDown(items, items.length - 1, i);
        }

        for (int i = items.length - 1; i > 0; i--) {
            swap(items, 0, i);
            shiftDown(items, i-1, 0);
        }

    }

    public static void main(String[] args) {
        HeapSort<Integer> heapSort = new HeapSort<>();
        Integer[] items = new Integer[]{23,12,444,3,1,4,5};
        heapSort.sort(items);
        for(Integer it : items){
            System.out.println(it);
        }
    }
}
