package com.oasis.problems.hot100;

import com.oasis.datastructure.ListNode;
import java.util.HashMap;
import java.util.Objects;

public class LeetCode160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (Objects.isNull(headA) || Objects.isNull(headB)) {
            return null;
        }
        ListNode p1 = headA, p2 = headB;
        while (p1 != p2) {
            p1 = Objects.isNull(p1) ? headB : p1.next;
            p2 = Objects.isNull(p2) ? headA : p2.next;
        }
        return p1;
    }
}
