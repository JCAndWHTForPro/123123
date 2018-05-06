package struct.impl;

import struct.List;

/**
 * 真正意义上的链表
 *
 * @Author: jicheng
 * @Since: 2018年05月02日 上午12:09
 */
public class LinkedList<E> implements List<E> {
    private class Node {
        private E data;
        private Node next;

        public Node(E data, Node next) {
            this.data = data;
            this.next = next;
        }

        public Node(E data) {
            this(data, null);
        }

        public Node() {
            this(null, null);
        }
    }

    private Node head;

    private int size;

    public LinkedList() {
        this.head = null;
        this.size = 0;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void resize(int resizeNum) {

    }

    @Override
    public boolean isEmpty() {
        return this.head == null;
    }

    @Override
    public boolean isContained(E e) {
        Node cur = head;
        for (int i = 0; i < this.size && cur != null; i++) {
            if (cur.data.equals(e)) {
                return true;
            }
            cur = cur.next;
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
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("excced range");
        }
        Node dummyNode = new Node(null, head);
        Node pre = dummyNode;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }

        pre.next = new Node(e, pre.next);
        this.size++;


    }

    @Override
    public void remove(E e) {
        Node pre = new Node(null, head);
        Node cur = head;
        while (cur != null) {
            if (cur.data.equals(e)) {
                pre.next = cur.next;
                cur.next = null;
                cur = pre.next;
                this.size--;
            } else {
                pre = cur;
                cur = cur.next;
            }
        }
    }

    @Override
    public E get(int index) {
        if (index < 0 || index > size - 1) {
            throw new IllegalArgumentException("error");
        }
        Node cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }

        return cur.data;
    }

    @Override
    public int find(E e) {
        return -1;
    }
}
