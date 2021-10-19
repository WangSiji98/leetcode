package com.oasis.problems.amazon.leetcode;

import com.oasis.datastructure.TreeNode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class LeetCode863 {
    private Map<Integer, TreeNode> map = new HashMap<>();
    private List<Integer> res = new ArrayList<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        if (k == 0) {
            return new ArrayList<Integer>(){{
               add(target.val);
            }};
        }
        findParent(root);
        dfs(target, k, null);
        return res;
    }

    private void findParent(TreeNode root) {
        if (Objects.isNull(root)) {
            return;
        }
        if (Objects.nonNull(root.left)) {
            map.put(root.left.val, root);
            findParent(root.left);
        }
        if (Objects.nonNull(root.right)) {
            map.put(root.right.val, root);
            findParent(root.right);
        }
    }

    private void dfs(TreeNode root, int dis, TreeNode last) {
        if (Objects.isNull(root)) {
            return;
        }
        if (dis == 0) {
            res.add(root.val);
            return;
        }
        if (root.left != last) {
            dfs(root.left, dis - 1, root);
        }
        if (root.right != last) {
            dfs(root.right, dis - 1, root);
        }
        if (map.containsKey(root.val) && map.get(root.val) != last) {
            dfs(map.get(root.val), dis - 1, root);
        }
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(5);
        TreeNode node3 = new TreeNode(1);
        TreeNode node4 = new TreeNode(6);
        TreeNode node5 = new TreeNode(2);
        TreeNode node6 = new TreeNode(0);
        TreeNode node7 = new TreeNode(8);
        TreeNode node8 = new TreeNode(7);
        TreeNode node9 = new TreeNode(4);

        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;

        node3.left = node6;
        node3.right = node7;

        node5.left = node8;
        node5.right = node9;

        LeetCode863 leetCode863 = new LeetCode863();
        System.out.println(leetCode863.distanceK(node1, node2, 2));
    }

}
