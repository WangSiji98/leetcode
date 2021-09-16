package com.oasis.problems.amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class LeetCode133 {
    class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    Map<Integer, Node> map = new HashMap<>();

    public Node cloneGraph(Node node) {
        bfs(node);
        return node == null ? null : map.get(node.val);
    }

    // create map of all the vertices
    public void bfs(Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        boolean first = true;
        Node newRoot = null;
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            if (!map.containsKey(cur.val)) {
                map.put(cur.val, new Node(cur.val));
            }
            for (Node node: cur.neighbors) {
                if (!map.containsKey(node.val)) {
                    map.put(node.val, new Node(node.val));
                    queue.offer(node);
                }
                map.get(cur.val).neighbors.add(map.get(node.val));
            }
        }
    }
}
