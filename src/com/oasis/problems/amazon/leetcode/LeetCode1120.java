package com.oasis.problems.amazon.leetcode;

import com.oasis.datastructure.TreeNode;

public class LeetCode1120 {
    private double max = 0.0;
    private static class Pair {
        double mean;
        int count;
        Pair(){}
        Pair(double _mean, int _count) {
            mean = _mean;
            count = _count;
        }
        double getMean() {
            return mean;
        }
        int getCount() {
            return count;
        }
    }

    public double maximumAverageSubtree(TreeNode root) {
        getMean(root);
        return max;
    }

    private Pair getMean(TreeNode root) {
        if (root == null) {
            return new Pair(0.0, 0);
        }
        Pair left = getMean(root.left);
        Pair right = getMean(root.right);
        int count = left.getCount() + right.getCount() + 1;
        double mean = (root.val + left.getMean() * left.getCount() + right.getMean() * right.getCount()) / count;
        max = Math.max(max, mean);
        return new Pair(mean, count);
    }

    public static void main(String[] args) {
        LeetCode1120 leetCode1120 = new LeetCode1120();
        TreeNode node1 = new TreeNode(2);
        TreeNode node3 = new TreeNode(1);
        node1.left = null;
        node1.right = node3;
        TreeNode root = node1;
        System.out.println(leetCode1120.maximumAverageSubtree(root));
    }

}
