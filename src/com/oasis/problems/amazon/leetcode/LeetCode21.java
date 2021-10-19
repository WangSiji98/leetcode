package com.oasis.problems.amazon.leetcode;

import com.oasis.datastructure.ListNode;
import java.util.Objects;

public class LeetCode21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;
        while (Objects.nonNull(l1) && Objects.nonNull(l2)) {
            if (l1.val > l2.val) {
                head.next = l2;
                l2 = l2.next;
            } else {
                head.next = l1;
                l1 = l1.next;
            }
            head = head.next;
        }
        head.next = Objects.isNull(l1) ? l2 : l1;

        return dummy.next;
    }

}
