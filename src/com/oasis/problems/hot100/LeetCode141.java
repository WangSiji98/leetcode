package com.oasis.problems.hot100;

import com.oasis.datastructure.ListNode;
import java.util.Objects;

public class LeetCode141 {
    public boolean hasCycle(ListNode head) {
        ListNode fast = head, slow = head;
        do {
            if (Objects.isNull(fast) || Objects.isNull(fast.next)) {
                return false;
            }
            fast = fast.next.next;
            slow = slow.next;
        } while (fast != slow);
        return true;
    }
}
