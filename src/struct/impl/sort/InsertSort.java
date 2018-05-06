package struct.impl.sort;

/**
 * 插入排序
 * @Author: jicheng
 * @Since: 2018年05月03日 下午5:47
 */
public class InsertSort<E extends Comparable<E>> extends BaseSort<E> {

    @Override
    public void sort(E[] items) {
        if (isEmpty(items)) {
            return;
        }
        for (int i = 1; i < items.length; i++) {
            for (int j = i; j > 0 && items[j].compareTo(items[j-1])<0; j--) {
                swap(items,j,j-1);
            }
        }
    }



    public static void main(String[] args) {
        InsertSort<Integer> insertSort = new InsertSort<>();
        Integer[] items = new Integer[]{12,23,1,3,34,44};
        insertSort.sort(items);
        for(Integer it : items)
            System.out.println(it);
    }
}
