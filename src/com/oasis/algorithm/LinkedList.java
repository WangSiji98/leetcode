package com.oasis.algorithm;

import com.oasis.datastructure.ListNode;
import java.util.List;
import java.util.Objects;

/**
 * 链表相关算法
 */
public class LinkedList {
    // 普通版本的反转链表，仅仅给出头节点
    public static ListNode reverse1(ListNode head) {
        if (Objects.isNull(head)) {
            return null;
        }
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    // 反转指定起点和终点（不反转终点）
    public static ListNode reverse2(ListNode start, ListNode end) {
        if (Objects.isNull(start)) {
            return null;
        }
        ListNode prev = null;
        ListNode cur = start;
        while (cur != end) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    public static ListNode add(ListNode p1, ListNode p2) {
        ListNode dummy = new ListNode();
        ListNode p = dummy;
        int carry = 0;
        while (p1 != null && p2 != null) {
            int sum = p1.val + p2.val + carry;
            carry = sum / 10;
            p.next = new ListNode(sum % 10);
            p1 = p1.next;
            p2 = p2.next;
            p = p.next;
        }
        if (p2 != null) {
            p1 = p2;
        }
        while (p1 != null) {
            int sum = p1.val + carry;
            carry = sum / 10;
            p.next = new ListNode(sum % 10);
            p1 = p1.next;
            p = p.next;
        }
        if (carry != 0) {
            p.next = new ListNode(carry);
        }
        return dummy.next;
    }

    private static void print(ListNode head) {
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    public static void main(String[] args) {
        ListNode node0 = new ListNode(0);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node0.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;


        print(add(node1, node2));

    }
}
