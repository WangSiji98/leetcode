package com.oasis.problems.baidu;

public class Jianzhi22 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        int n = 0;
        ListNode p = head;
        while (p != null) {
            ++n;
            p = p.next;
        }
        p = head;
        for (int i = 0; i < n - k; ++i) {
            p = p.next;
        }
        return p;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        Jianzhi22 jianzhi22 = new Jianzhi22();

        System.out.println(jianzhi22.getKthFromEnd(node1, 1).val);
    }

}
