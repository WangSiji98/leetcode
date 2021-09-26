package com.oasis.problems.hot100;

import com.oasis.datastructure.ListNode;
import java.util.Objects;

public class LeetCode148 {
    public ListNode sortList(ListNode head) {
        return sort(head, null);
    }

    private ListNode sort(ListNode head, ListNode tail) {
        if (Objects.isNull(head)) {
            return null;
        }
        if (head.next == tail) {
            head.next = null;
            return head;
        }
        ListNode fast = head, slow = head;
        while (fast != tail) {
            fast = fast.next;
            slow = slow.next;
            if (fast != tail) {
                fast = fast.next;
            }
        }
        ListNode mid = slow;
        ListNode p1 = sort(head, mid);
        ListNode p2 = sort(mid, tail);
        ListNode p = merge(p1, p2);
        return p;
    }

    private ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode();
        ListNode p1 = head1, p2 = head2, p = dummy;
        while (Objects.nonNull(p1) && Objects.nonNull(p2)) {
            if (p1.val <= p2.val) {
                p.next = p1;
                p1 = p1.next;
            } else {
                p.next = p2;
                p2 = p2.next;
            }
            p = p.next;
        }
        if (p1 != null) {
            p.next = p1;
        } else if (p2 != null) {
            p.next = p2;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        LeetCode148 leetCode148 = new LeetCode148();
        ListNode p0 = new ListNode(4);
        ListNode p1 = new ListNode(2);
        ListNode p2 = new ListNode(1);
        ListNode p3 = new ListNode(3);
        p0.next = p1;
        p1.next = p2;
        p2.next = p3;
        p3.next = null;
        ListNode head = p0;
        head = leetCode148.sortList(head);
        ListNode p = head;
        while (Objects.nonNull(p)) {
            System.out.println(p.val);
            p = p.next;
        }
    }
}
