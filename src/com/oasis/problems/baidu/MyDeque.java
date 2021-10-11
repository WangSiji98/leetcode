package com.oasis.problems.baidu;

// 手写双向链表
class DoubleLink<E> {

    private class Node<E> {
        public E value; // 节点值
        public Node<E> prev; // 前一个节点
        public Node<E> next; // 后一个节点

        public Node(E value, Node<E> prev, Node<E> next) {
            this.value = value;
            this.prev = prev;
            this.next = next;
        }
    }

    private int size;// 链表长度
    public Node<E> head;// 头节点

    /**
     * constructor
     */
    public DoubleLink() {
        // 头节点不存储值
        head = new Node<E>(null, null, null);
        head.prev = head.next = head;
        size = 0;
    }

    /**
     * 获取链表的长度
     *
     * @return
     */
    public int size() {
        return size;
    }

    /**
     * 判断链表是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 验证索引的合法性
     *
     * @param index
     */
    public void rangeCheck(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     * 获取位置为index的节点
     *
     * @param index
     * @return
     */
    private Node<E> getNode(int index) {
        rangeCheck(index);
        if (index <= size / 2) {
            Node<E> cur = head.next;
            for (int i = 0; i < index; i++) {
                cur = cur.next;
            }
            return cur;
        }
        Node<E> cur = head.prev;
        int newIndex = size - index - 1;
        for (int i = 0; i < newIndex; i++) {
            cur = cur.prev;
        }
        return cur;
    }

    /**
     * 获取位置为index的节点值
     *
     * @return
     */
    public E get(int index) {
        return getNode(index).value;
    }

    /**
     * 获取第一个节点的值
     *
     * @return
     */
    public E getFirst() {
        return getNode(0).value;
    }

    /**
     * 获取最后一个节点的值
     *
     * @return
     */
    public E getLast() {
        return getNode(size - 1).value;
    }

    /**
     * 插入节点
     *
     * @param index
     * @param value
     */
    public void insert(int index, E value) {
        if (index == 0) {
            Node<E> cur = new Node<E>(value, head, head.next);
            head.next.prev = cur;
            head.next = cur;
            size++;
            return;
        }

        Node<E> node = getNode(index - 1);
        Node<E> cur = new Node<E>(value, node, head);
        node.next = cur;
        head.prev = cur;
        size++;
    }

    /**
     * 添加到链表的头部
     *
     * @param value
     */
    public void addFirst(E value) {
        insert(0, value);
    }

    /**
     * 添加节点到链表的尾部
     *
     * @param value
     */
    public void addLast(E value) {
        Node<E> cur = new Node<E>(value, head.prev, head);
        head.prev.next = cur;
        head.prev = cur;
        size++;
    }

    /**
     * 删除位置为index的节点
     *
     * @param index
     */
    public void delete(int index) {
        rangeCheck(index);
        Node<E> cur = getNode(index);
        cur.prev.next = cur.next;
        cur.next.prev = cur.prev;
        size--;
        cur = null;
    }

    /**
     * 删除第一个节点
     */
    public void deleteFirst() {
        delete(0);
    }

    /**
     * 删除最后一个节点
     */
    public void deleteLast() {
        delete(size - 1);
    }

}

public class MyDeque {
    public static void main(String[] args) {
        DoubleLink<Integer> dl = new DoubleLink<Integer>();
        dl.insert(0, 1);
        dl.insert(1, 2);
        dl.insert(2, 3);
        dl.insert(3, 4);
        dl.deleteLast();
        for (int i = 0; i < dl.size(); i++) {
            System.out.print(dl.get(i) + " ");
        }
    }
}