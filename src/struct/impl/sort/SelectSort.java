package struct.impl.sort;

/**
 * 选择排序
 * @Author: jicheng
 * @Since: 2018年05月03日 下午1:39
 */
public class SelectSort<E extends Comparable<E>> extends BaseSort<E>{

    @Override
    public void sort(E[] items){
        if(isEmpty(items)){
            return;
        }

        for(int i=0;i<items.length;i++){
            int minIndex = i;
            for(int j=i+1;j<items.length;j++){
                if(items[j].compareTo(items[minIndex])<0){
                    minIndex = j;
                }
            }
            if(minIndex!=i){
                swap(items,minIndex,i);
            }
        }


    }

    public static void main(String[] args) {
        SelectSort<Integer> selectSort = new SelectSort<>();
        Integer[] items = new Integer[]{2,4,6,34,2,1,0};
        selectSort.sort(items);
        for(Integer it : items)
        System.out.println(it);
    }
}
