package com.oasis.problems.alibaba;


import com.oasis.algorithm.LinkedList;
import com.oasis.datastructure.ListNode;

class Solution328 {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode oddHead = head;
        ListNode evenHead = head.next;

        ListNode odd = oddHead, even = evenHead;

        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }

        odd.next = evenHead;
        return oddHead;
    }
}

public class LeetCode328 {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        ListNode head = node1;

        Solution328 solution328 = new Solution328();
        LinkedList.print(solution328.oddEvenList(head));

    }




}
