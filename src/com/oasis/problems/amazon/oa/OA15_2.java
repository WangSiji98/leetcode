package com.oasis.problems.amazon.oa;

import com.oasis.datastructure.ListNode;
import com.oasis.datastructure.TreeNode;
import java.util.List;

/**
 * lc 24
 *
 * https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 */

public class OA15_2 {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode fast = head.next;
        ListNode slow = head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        while (fast != null) {
            ListNode next = fast.next;
            prev.next = fast;
            fast.next = slow;
            slow.next = next;
            prev = slow;
            fast = slow.next;
            if (fast == null) {
                break;
            } else {
                if (fast.next == null) {
                    break;
                } else {
                    fast = fast.next;
                    slow = slow.next;
                }
            }
        }
        return dummy.next;
    }

    private void print(ListNode p) {
        while (p != null) {
            System.out.println(p.val);
            p = p.next;
        }
    }

    public static void main(String[] args) {
        OA15_2 oa15_2 = new OA15_2();

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
//        node4.next = node5;

        oa15_2.print(oa15_2.swapPairs(node1));

    }

}
