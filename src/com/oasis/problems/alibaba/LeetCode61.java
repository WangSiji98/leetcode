package com.oasis.problems.alibaba;

import com.oasis.algorithm.LinkedList;
import com.oasis.datastructure.ListNode;

public class LeetCode61 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode p = head;
        int l = 0;
        while (p.next != null) {
            p = p.next;
            ++l;
        }
        ++l;

        p.next = head;
        p = head;
        for (int i = 0; i < l - (k % l) - 1; ++i) {
            p = p.next;
        }
        ListNode res = p.next;
        p.next = null;


        return res;
    }

    public static void main(String[] args) {
        LeetCode61 leetCode61 = new LeetCode61();

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;


        ListNode head = node1;

        LinkedList.print(leetCode61.rotateRight(head, 5));

    }

}
