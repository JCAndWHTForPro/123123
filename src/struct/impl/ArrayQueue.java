package struct.impl;

import struct.Queue;

/**
 * @Author: jicheng
 * @Since: 2018年05月02日 下午5:25
 */
public class ArrayQueue<E> implements Queue<E> {

    private static final int INIT_CAPACITY = 10;

    private E[] datas;

    private int front;

    private int last;

    private int size;

    public ArrayQueue(int capacity) {
        datas = (E[]) new Object[capacity];
        this.front = this.last = 0;
        this.size = 0;
    }

    public ArrayQueue() {
        this(INIT_CAPACITY);
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.front == this.last;
    }

    private boolean isFull() {
        return (this.last + 1) % this.datas.length == this.front;
    }

    @Override
    public void enQueue(E e) {
        if (isFull()) {
            this.resize(this.size * 2);
        }
        this.datas[this.last] = e;
        this.last = (this.last + 1) % this.datas.length;
        this.size++;

    }

    @Override
    public E deQueue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("empty queue");
        }
        E item = this.datas[this.front];
        this.datas[this.front] = null;
        this.front = (this.front + 1) % this.datas.length;
        this.size--;
        if (this.size <= this.datas.length / 4) {
            this.resize(this.datas.length / 2);
        }
        return item;
    }

    @Override
    public void resize(int num) {
        E[] newDatas = (E[]) new Object[num];
        for (int i = 0; i < this.size; i++) {
            newDatas[i] = this.datas[(i + this.front) % this.datas.length];
        }
        this.front = 0;
        this.last = this.size;
        this.datas = newDatas;

    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int f = this.front;
        int l = this.last;
        while (f != l) {
            sb.append(this.datas[f]).append(",");
            f = (f + 1) % this.datas.length;
        }
        return sb.substring(0, sb.length() - 1).toString();
    }
}
