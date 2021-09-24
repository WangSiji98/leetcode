package com.oasis.problems.amazon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCode117 {
    static class Node {
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

    // 最简单的办法 肯定是层序遍历
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Node> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node cur = queue.poll();
                list.add(cur);
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            for (int i = 0; i < size - 1; i++) {
                list.get(i).next = list.get(i + 1).next;
            }
        }
        return root;
    }

    // 实际上还有更加高效的办法
    // 进阶办法 使用O(1)空间
    public Node connect1(Node root) {
        return null;
    }



    public static void main(String[] args) {
        LeetCode117 leetCode117 = new LeetCode117();
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node7 = new Node(7);

        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;

        node3.right = node7;

        Node root = node1;
    }


}
