package com.oasis.problems.amazon.leetcode;


import java.util.Objects;

public class LeetCode138 {
    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        Node p = head;
        while (Objects.nonNull(p)) {
            Node dup = new Node(p.val);
            dup.next = p.next;
            p.next = dup;
            p = dup.next;
        }
        p = head;
        while (Objects.nonNull(p)) {
            Node dup = p.next;
            dup.random = Objects.nonNull(p.random) ? p.random.next : null;
            p = p.next.next;
        }
        Node dummy = new Node(-1);
        p = head;
        Node q = dummy;
        while (Objects.nonNull(p)) {
            q.next = p.next;
            p.next = p.next.next;
            p = p.next;
            q = q.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        Node node1 = new Node(7);
        Node node2 = new Node(13);
        Node node3 = new Node(11);
        Node node4 = new Node(10);
        Node node5 = new Node(1);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;

        node1.random = null;
        node2.random = node1;
        node3.random = node5;
        node4.random = node3;
        node5.random = node1;

        LeetCode138 leetCode138 = new LeetCode138();

        Node newHead = leetCode138.copyRandomList(node1);
    }
}
