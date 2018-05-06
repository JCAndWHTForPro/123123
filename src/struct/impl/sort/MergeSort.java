package struct.impl.sort;

/**
 * 并归排序
 * @Author: jicheng
 * @Since: 2018年05月03日 下午6:44
 */
public class MergeSort<E extends Comparable<E>> extends BaseSort<E> {

    @Override
    public void sort(E[] items) {
        if (isEmpty(items)) {
            return;
        }

        mergeSort2(items, 0, items.length - 1);

    }

    private void mergeSort(E[] items, int begin, int end) {
        if (begin >= end) {
            return;
        }
        int mid = (begin + end) / 2;
        mergeSort(items, begin, mid);
        mergeSort(items, mid + 1, end);


        merge(items, begin, end, mid);

    }

    private void merge(E[] items, int begin, int end, int mid) {
        E[] tempItems = (E[]) new Comparable[items.length];
        for (int i = begin; i <= end; i++) {
            tempItems[i - begin] = items[i];
        }

        int indexB = begin;
        int indexE = mid + 1;
        for (int i = begin; i <= end; i++) {
            if (indexB > mid) {
                items[i] = tempItems[indexE - begin];
                indexE++;
            } else if (indexE > end) {
                items[i] = tempItems[indexB - begin];
                indexB++;
            } else if (tempItems[indexB - begin].compareTo(tempItems[indexE - begin]) < 0) {
                items[i] = tempItems[indexB - begin];
                indexB++;
            } else {
                items[i] = tempItems[indexE - begin];
                indexE++;
            }
        }
    }


    /**
     * 小规模的归并排序使用插入排序算法
     * @param items
     * @param begin
     * @param end
     */
    private void mergeSort2(E[] items, int begin, int end) {
        if (end-begin<15) {
            InsertSort<E> insertSort = new InsertSort<>();
            insertSort.sort(items);
            return;
        }
        int mid = (begin + end) / 2;
        mergeSort(items, begin, mid);
        mergeSort(items, mid + 1, end);


        merge(items, begin, end, mid);

    }

    public static void main(String[] args) {
        MergeSort<Integer> mergeSort = new MergeSort<>();
        Integer[] integers = new Integer[]{23,34,45,2,3,5,333};
        mergeSort.sort(integers);
        for(Integer it : integers){
            System.out.println(it);
        }
    }
}
