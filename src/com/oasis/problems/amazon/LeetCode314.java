package com.oasis.problems.amazon;

import com.oasis.datastructure.TreeNode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class LeetCode314 {
    private static class Pair {
        private TreeNode node;
        private int index;

        public Pair(){}

        public Pair(TreeNode _node, int _index) {
            this.node = _node;
            this.index = _index;
        }

        public TreeNode getNode() {
            return this.node;
        }

        public int getIndex() {
            return this.index;
        }
    }

    private final Map<Integer, List<Integer>> map = new HashMap<>();

    public List<List<Integer>> verticalOrder(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0));
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                Pair cur = queue.poll();
                int index = cur.getIndex();
                TreeNode curNode = cur.getNode();
                if (map.containsKey(index)) {
                    map.get(index).add(curNode.val);
                } else {
                    map.put(index, new ArrayList<Integer>(){{add(curNode.val);}});
                }
                if (curNode.left != null) {
                    queue.offer(new Pair(curNode.left, index - 1));
                }
                if (curNode.right != null) {
                    queue.offer(new Pair(curNode.right, index + 1));
                }
            }
        }
        List<Integer> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys);
        List<List<Integer>> res = new ArrayList<>();
        for (int key: keys) {
            res.add(map.get(key));
        }
        return res;
    }


    // dfs不行，没法保证顺序
    public List<List<Integer>> verticalOrderDfs(TreeNode root) {
        dfs(root, 0);
        List<Integer> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys);
        List<List<Integer>> res = new ArrayList<>();
        for (int key: keys) {
            res.add(map.get(key));
        }
        return res;
    }

    private void dfs(TreeNode root, int index) {
        if (root == null) {
            return;
        }
        if (map.containsKey(index)) {
            map.get(index).add(root.val);
        } else {
            map.put(index, new ArrayList<Integer>(){{add(root.val);}});
        }
        dfs(root.left, index - 1);
        dfs(root.right, index + 1);
    }



    public static void main(String[] args) {
        LeetCode314 leetCode314 = new LeetCode314();
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(8);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(0);
        TreeNode node6 = new TreeNode(1);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(5);
        TreeNode node9 = new TreeNode(2);

        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;

        node3.left = node6;
        node3.right = node7;

        node5.right = node9;
        node6.left = node8;

        TreeNode root = node1;

        System.out.println(leetCode314.verticalOrder(root));
    }
}
