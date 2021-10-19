package com.oasis.problems.amazon.leetcode;

import com.oasis.datastructure.TreeNode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LeetCode545 {
    private List<Integer> boundary = new ArrayList<>();
    private List<Integer> leftBoundary = new ArrayList<>();
    private List<Integer> rightBoundary = new ArrayList<>();
    private List<Integer> leaves = new ArrayList<>();

    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        if (root.left == null && root.right == null) {
            return new ArrayList<Integer>(){{
                add(root.val);
            }};
        }
        dfs(root, 0);
        dfs(root.left, 1);
        dfs(root.right, -1);
        List<Integer> res = new ArrayList<>();
        Collections.reverse(rightBoundary);
        res.add(root.val);
        res.addAll(leftBoundary);
        res.addAll(leaves);
        res.addAll(rightBoundary);
        return res;
    }

    private void dfs(TreeNode root, int flag) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            if (flag == 0) {
                leaves.add(root.val);
            }
            return;
        }
        if (flag == 1) {
            leftBoundary.add(root.val);
            if (root.left != null) {
                dfs(root.left, 1);
            } else {
                dfs(root.right, 1);
            }
        } else if (flag == -1) {
            rightBoundary.add(root.val);
            if (root.right != null) {
                dfs(root.right, -1);
            } else {
                dfs(root.left, -1);
            }
        } else {
            if (root.left != null) {
                dfs(root.left, 0);
            }
            if (root.right != null) {
                dfs(root.right, 0);
            }
        }
    }

    public static void main(String[] args) {
        LeetCode545 leetCode545 = new LeetCode545();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        TreeNode node9 = new TreeNode(9);
        TreeNode node10 = new TreeNode(10);

        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;

        node3.left = node6;

        node5.left = node7;
        node5.right = node8;

        node6.left = node9;
        node6.right = node10;

        TreeNode root = node1;
//        leetCode545.boundaryOfBinaryTree(root);
        System.out.println(leetCode545.boundaryOfBinaryTree(root));
    }

}
