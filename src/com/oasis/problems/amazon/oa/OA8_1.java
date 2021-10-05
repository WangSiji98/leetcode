package com.oasis.problems.amazon.oa;

import com.oasis.datastructure.ListNode;
import java.util.List;

/**
 * LC21
 *
 * 合并俩有序链表
 */

public class OA8_1 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        p.next = l1 == null ? l2 : l1;
        return dummy.next;
    }

}
