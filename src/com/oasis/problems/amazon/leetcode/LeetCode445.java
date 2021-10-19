package com.oasis.problems.amazon.leetcode;

import com.oasis.algorithm.LinkedList;
import com.oasis.datastructure.ListNode;
import java.util.Objects;
import javax.jws.Oneway;

public class LeetCode445 {
    public static ListNode reverse(ListNode head) {
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

    // 链表逐位置相加 需要考虑进位
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

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (Objects.isNull(l1) || Objects.isNull(l2)) {
            return l1 == null ? l2 : l1;
        }
        ListNode tail1 = reverse(l1);
        ListNode tail2 = reverse(l2);
        ListNode tail = add(tail1, tail2);
        return reverse(tail);
    }

}
