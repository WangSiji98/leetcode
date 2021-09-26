package com.oasis.problems.hot100;

import com.oasis.datastructure.ListNode;
import java.util.HashMap;
import java.util.Objects;

public class LeetCode234 {
    public boolean isPalindrome(ListNode head) {
        if (Objects.isNull(head) || Objects.isNull(head.next)) {
            return true;
        }
        ListNode mid = findMid(head);
        ListNode newHead = reverse(mid);
        ListNode p1 = head, p2 = newHead;
        boolean res = true;
        while (res && p2 != null) {
            if (p1.val != p2.val) {
                res = false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        mid.next = reverse(newHead);
        return res;
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null, cur = head;
        while (Objects.nonNull(cur)) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    private ListNode findMid(ListNode head) {
        ListNode fast = head, slow = head;
        while (Objects.nonNull(fast)) {
            fast = fast.next;
            slow = slow.next;
            if (Objects.nonNull(fast)) {
                fast = fast.next;
            }
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode p0 = new ListNode(1);
        ListNode p1 = new ListNode(2);
        ListNode p2 = new ListNode(2);
        ListNode p3 = new ListNode(1);
        ListNode head = p0;
        p0.next = p1;
        p1.next = p2;
        p2.next = p3;
        p3.next = null;

        LeetCode234 leetCode234 = new LeetCode234();
        System.out.println(leetCode234.isPalindrome(head));
    }
}
