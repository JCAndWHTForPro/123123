package struct.impl;


import struct.Queue;

/**
 * 大顶堆
 *
 * @Author: jicheng
 * @Since: 2018年05月03日 上午10:25
 */
public class PriorityQueue<E extends Comparable<E>> implements Queue<E> {
    private static final int INITIAL_CAPACITY = 10;

    private E[] datas;

    private int size;

    public PriorityQueue(int capacity) {
        datas = (E[]) new Object[capacity + 1];
        size = 0;
    }

    public PriorityQueue(E[] initialItems) {
        this.datas = initialItems;
        this.size = initialItems.length;
        int lastIndex = initialItems.length - 1;
        int parent = this.parent(lastIndex);
        for (int i = parent; i >= 0; i--) {
            shiftDown(i);
        }

    }

    public PriorityQueue() {
        this(INITIAL_CAPACITY);
    }

    @Override
    public int size() {
        return this.size;
    }

    private int leftChild(int index) {
        return index * 2 + 1;
    }

    private int rightChild(int index) {
        return index * 2 + 2;
    }

    private int parent(int index) {
        return (index - 1) / 2;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public void enQueue(E e) {
        if (e == null) {
            return;
        }
        if (this.size + 1 == this.datas.length) {
            this.resize(this.datas.length * 2);
        }
        this.datas[this.size] = e;
        shiftUp(this.size);
        this.size++;
    }

    private void shiftUp(int index) {
        if (index < 0 || index > this.datas.length - 1) {
            throw new IllegalArgumentException("over range");
        }
        if (this.size == 0) {
            return;
        }
        int parentIndex = this.parent(index);
        while (index > 0 && this.datas[parentIndex].compareTo(this.datas[index]) < 0) {
            swap(this.datas, index, parentIndex);
            index = parentIndex;
            parentIndex = this.parent(index);
        }
    }

    private void shiftDown(int index) {
        if (index < 0 || index > this.datas.length - 1) {
            throw new IllegalArgumentException("over range");
        }
        if (this.size == 0) {
            return;
        }
        while (index < this.size) {
            int leftIndex = this.leftChild(index);
            int rightIndex = this.rightChild(index);
            int maxIndex = index;
            if (this.datas[leftIndex] != null && this.datas[leftIndex].compareTo(this.datas[maxIndex]) > 0) {
                maxIndex = leftIndex;
            }
            if (this.datas[rightIndex] != null && this.datas[rightIndex].compareTo(this.datas[maxIndex]) > 0) {
                maxIndex = rightIndex;
            }
            if (maxIndex != index) {
                swap(this.datas, maxIndex, index);
                index = maxIndex;
            } else {
                break;
            }


        }

    }

    private void swap(E[] datas, int index, int parentIndex) {
        E tempData = datas[index];
        datas[index] = datas[parentIndex];
        datas[parentIndex] = datas[index];
    }


    @Override
    public E deQueue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("empty");
        }
        E result = this.datas[0];
        swap(this.datas, 0, this.size - 1);
        shiftDown(0);
        this.size--;
        if (this.size < this.datas.length / 4) {
            this.resize(this.datas.length / 2);
        }
        return result;
    }

    @Override
    public void resize(int num) {
        E[] newDatas = (E[]) new Object[num + 1];
        for (int i = 0; i < size; i++) {
            newDatas[i] = datas[i];
        }
        datas = newDatas;
    }
}
