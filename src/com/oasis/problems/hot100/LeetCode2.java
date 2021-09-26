package com.oasis.problems.hot100;

import com.oasis.datastructure.ListNode;
import java.util.Objects;

public class LeetCode2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null, tail = null;
        int carry = 0;
        int sum = 0;

        while (Objects.nonNull(l1) || Objects.nonNull(l2)) {
            int n1 = l1 != null? l1.val: 0;
            int n2 = l2 != null? l2.val: 0;
            sum = n1 + n2 + carry;
            carry = sum / 10;
            if (head == null) {
                head = tail = new ListNode(sum % 10);
            } else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
            if (Objects.nonNull(l1)) {
                l1 = l1.next;
            }
            if (Objects.nonNull(l2)) {
                l2 = l2.next;
            }
        }

        if (carry > 0) {
            tail.next = new ListNode(carry);
        }

        return head;
    }

}
