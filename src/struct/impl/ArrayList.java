package struct.impl;

import struct.List;

/**
 * 数组封装
 *
 * @Author: jicheng
 * @Since: 2018年05月01日 下午11:26
 */
public class ArrayList<E> implements List<E> {

    private static final int INITIAL_CAPACITY = 10;
    private E[] data;
    private int size;
    public ArrayList(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }

    public ArrayList(){
        this(INITIAL_CAPACITY);
    }



    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void resize(int resizeNum) {
        E[] newData = (E[]) new Object[resizeNum];
        for (int i = 0; i < this.size; i++) {
            newData[i] = data[i];
        }
        this.data = newData;

    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public boolean isContained(E e) {
        for (E it : data) {
            if (e != null && e.equals(it)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void addFirst(E e) {
        this.add(0, e);
    }

    @Override
    public void addLast(E e) {
        this.add(this.size, e);
    }

    @Override
    public void add(int index, E e) {
        checkIndex(index);
        if (this.size == this.data.length) {
            this.resize(this.size * 2);
        }
        for (int i = this.size; i > index; i--) {
            this.data[i] = this.data[i - 1];
        }
        this.data[index] = e;
        this.size++;

    }

    private void checkIndex(int index) {
        if (index < 0 || index > this.data.length - 1) {
            throw new IllegalArgumentException("exceed range error");
        }
    }

    @Override
    public void remove(E e) {
        int index = this.find(e);
        if (index > -1) {
            for (int i = index; i < size; i++) {
                this.data[i] = this.data[i + 1];
            }
            this.data[size - 1] = null;
            this.size--;
            if (this.size <= this.data.length / 2) {
                this.resize(this.data.length / 2);
            }
        }

    }

    @Override
    public E get(int index) {
        this.checkIndex(index);
        return this.data[index];
    }

    @Override
    public int find(E e) {
        if (e == null) {
            return -1;
        }
        for (int i = 0; i < this.size; i++) {
            if (e.equals(data[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < this.size; i++) {
            sb.append(this.data[i]);
            if (i < this.size - 1) {
                sb.append(",");
            }

        }
        return sb.toString();
    }


}
