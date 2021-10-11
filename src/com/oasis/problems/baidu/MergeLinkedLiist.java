package com.oasis.problems.baidu;

class ListNode {
    public int val;
    public ListNode next;

    public ListNode(){}
    public ListNode(int _val) {
        val = _val;
        next = null;
    }
    public ListNode(int _val, ListNode _next) {
        val = _val;
        next = _next;
    }
}

public class MergeLinkedLiist {
    public static ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        while (head1 != null && head2 != null) {
            if (head1.val > head2.val) {
                p.next = head2;
                head2 = head2.next;
            } else {
                p.next = head1;
                head1 = head1.next;
            }
            p = p.next;
        }
        p.next = head1 == null ? head2 : head1;
        return dummy.next;
    }

    private static void print(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            System.out.println(" ");
            head = head.next;
        }
    }

    public static void main(String[] args) {
        ListNode node11 = new ListNode(1);
        ListNode node12 = new ListNode(3);
        ListNode node13 = new ListNode(5);
        ListNode node21 = new ListNode(2);
        ListNode node22 = new ListNode(4);
        ListNode node23 = new ListNode(6);
        ListNode node24 = new ListNode(8);

        node11.next = node12;
        node12.next = node13;

        node21.next = node22;
        node22.next = node23;
        node23.next = node24;

        ListNode head1 = node11;
        ListNode head2 = node21;

        ListNode head = merge(head1, head2);
        print(head);
    }
}
