package com.oasis.problems.amazon.leetcode;

import com.oasis.datastructure.UnionFind;

public class LeetCode547 {
    private UnionFind unionFind;

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        unionFind = new UnionFind(n);
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (isConnected[i][j] == 1) {
                    unionFind.union(i, j);
                }
            }
        }
        return unionFind.getSize();
    }

    public static void main(String[] args) {
        LeetCode547 leetCode547 = new LeetCode547();
        int[][] isConnected = new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        System.out.println(leetCode547.findCircleNum(isConnected));
    }

}
