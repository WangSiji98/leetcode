package com.oasis.problems.amazon.leetcode;

public class LeetCode323 {
    static class UnionFind {
        public int[] parent;
        private int[] rank;
        int count;

        public UnionFind() {};
        public UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            count = n;
            // 初始化所有节点的父亲为自己
            for (int i = 0; i < n; ++i) {
                parent[i] = i;
                rank[i] = 1;
            }
        }

        public int getSize() {
            return count;
        }

        // 带路径压缩
        private int find(int i) {
            if (i != parent[i]) {
                parent[i] = find(parent[i]);
            }
            return parent[i];
        }

        public boolean isConnected(int i , int j){
            return find(i) == find(j);
        }

        public void union(int i, int j) {
            int iRoot = find(i);
            int jRoot = find(j);
            if (iRoot == jRoot) {
                return;
            }
            --count;
            if (rank[iRoot] > rank[jRoot]) {
                parent[jRoot] = iRoot;
            } else if (rank[iRoot] < rank[jRoot]) {
                parent[iRoot] = jRoot;
            } else {
                parent[jRoot] = iRoot;
                ++rank[iRoot];
            }
        }
    }
    private UnionFind unionFind;

    public int countComponents(int n, int[][] edges) {
        unionFind = new UnionFind(n);
        for (int i = 0; i < edges.length; ++i) {
            unionFind.union(edges[i][0], edges[i][1]);
        }
        return unionFind.getSize();
    }

    public static void main(String[] args) {
        LeetCode323 leetCode323 = new LeetCode323();
        int n = 5;
        int[][] edges = new int[][]{{0, 1}, {1, 2}, {3, 4}};
        System.out.println(leetCode323.countComponents(n, edges));
    }

}
