package com.oasis.problems.hot100;
import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    protected static class DListNode {
        public int key;
        public int value;
        public DListNode prev;
        public DListNode next;
        DListNode() {
            this.key = -1;
            this.value = -1;
            this.prev = null;
            this.next = null;}
        DListNode(int key, int value) {
            this.key = key;
            this.value = value;
            this.prev = null;
            this.next = null;
        }
    }

    private int capacity;
    private Map<Integer, DListNode> cache = new HashMap<>();
    private int curSize;
    private DListNode dummyHead, dummyTail;

    public LRUCache(int capacity) {
        this.curSize = 0;
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.dummyHead = new DListNode();
        this.dummyTail = new DListNode();
        this.dummyHead.next = this.dummyTail;
        this.dummyTail.prev = this.dummyHead;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        DListNode node = cache.get(key);
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            DListNode node = cache.get(key);
            moveToHead(node);
            node.value = value;
            return;
        }
        if (this.curSize < this.capacity) {
            DListNode newNode = new DListNode(key, value);
            addToHead(newNode);
            cache.put(key, newNode);
            ++this.curSize;
            return;
        }
        DListNode removed = removeTail();
        cache.remove(removed.key);
        --this.curSize;
        this.put(key, value);
    }

    // 插入链表节点，双向
    private void addToHead(DListNode node) {
        node.prev = dummyHead;
        node.next = dummyHead.next;
        dummyHead.next.prev = node;
        dummyHead.next = node;
    }

    private DListNode removeTail() {
        DListNode tmp = dummyTail.prev;
        delete(tmp);
        return tmp;
    }

    private void moveToHead(DListNode node) {
        DListNode tmp = node;
        delete(tmp);
        addToHead(tmp);
    }

    private void delete(DListNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(2, 1);
        cache.put(1, 1);
        cache.put(2, 3);
        cache.put(4, 1);
        cache.get(2);
    }
}
