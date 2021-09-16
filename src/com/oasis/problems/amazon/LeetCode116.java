package com.oasis.problems.amazon;

import com.oasis.problems.amazon.LeetCode348.TicTacToe;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCode116 {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    // 这题一看就是层序遍历 但空间复杂度太高
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Node> list = new LinkedList<>();
            for (int i = 0; i < size; ++i) {
                Node cur = queue.poll();
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
                list.add(cur);
            }
            for (int i = 0; i < size - 1; ++i) {
                list.get(i).next = list.get(i + 1);
            }
        }
        return root;
    }

    public Node connect1(Node root) {
        if (root == null) {
            return root;
        }
        Node left = root;
        while (left.left != null) {
            Node cur = left;
            while (cur != null) {
                cur.left.next = cur.right;
                if (cur.next != null) {
                    cur.right.next = cur.next.left;
                }
                cur = cur.next;
            }
            left = left.left;
        }
        return root;
    }
}
