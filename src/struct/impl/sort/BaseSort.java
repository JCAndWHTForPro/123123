package struct.impl.sort;

/**
 * @Author: jicheng
 * @Since: 2018年05月03日 下午1:41
 */
public abstract class BaseSort<E extends Comparable<E>> {

    abstract protected void sort(E[] items);

    protected void swap(E[] items, int i, int j) {
        E tempData = items[i];
        items[i] = items[j];
        items[j] = tempData;
    }

    protected boolean isEmpty(E[] item){
        return item==null || item.length==0;
    }



}
