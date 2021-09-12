package com.oasis.datastructure;

import java.util.Random;

public class UnionFind {
    public int[] parent;
    private int[] rank;
    int size;

    public UnionFind() {};
    public UnionFind(int n) {
        parent = new int[n];
        rank = new int[n];
        size = n;
        // 初始化所有节点的父亲为自己
        for (int i = 0; i < n; ++i) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    // 带路径压缩
    private int find(int i) {
        assert(i >= 0 && i < size);
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
