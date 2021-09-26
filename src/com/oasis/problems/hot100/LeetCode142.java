package com.oasis.problems.hot100;

import com.oasis.datastructure.ListNode;
import java.util.List;
import java.util.Objects;

public class LeetCode142 {
    public ListNode detectCycle(ListNode head) {
        if (Objects.isNull(head)) {
            return null;
        }
        ListNode fast = head, slow = head;
        while (Objects.nonNull(fast)) {
            if (Objects.isNull(fast.next)) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                ListNode find = head;
                while (find != slow) {
                    find = find.next;
                    slow = slow.next;
                }
                return find;
            }
        }
        return null;
    }
}
