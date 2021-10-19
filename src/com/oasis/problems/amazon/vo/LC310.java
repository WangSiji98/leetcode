package com.oasis.problems.amazon.vo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

class FindMinHeightTrees {

    // 将所有入度为1的节点不断入队，逐渐逼近中央
    // https://leetcode-cn.com/problems/minimum-height-trees/solution/c-you-wai-zhi-nei-de-ceng-xu-bian-li-by-dnu8g/
    // 层序遍历 +拓扑排序


    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>();
        if (n == 1) {
            res.add(0);
            return res;
        }
        int[] degree = new int[n];
        List<List<Integer>> map = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            map.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            degree[edge[0]]++;
            degree[edge[1]]++;
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (degree[i] == 1) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            res = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                res.add(cur);
                List<Integer> neighbors = map.get(cur);
                for (int neighbor : neighbors) {
                    degree[neighbor]--;
                    if (degree[neighbor] == 1) {
                        queue.offer(neighbor);
                    }
                }
            }
        }
        return res;
    }

}


public class LC310 {

    private int[] visited = null;
    private Map<Integer, List<Integer>> edgeMap = new HashMap<>();

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        for (int[] edge: edges) {
            for (int i = 0; i < 2; ++i) {
                if (!edgeMap.containsKey(edge[i])) {
                    edgeMap.put(edge[i], new ArrayList<>());
                }
                edgeMap.get(edge[i]).add(edge[1 - i]);
            }
        }
        List<int[]> ans = new ArrayList<>();

        for (int i = 0; i < n; ++i) {
            visited = new int[n];
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(i);
            int height = -1;
            while (!queue.isEmpty()) {
                int len = queue.size();
                ++height;
                for (int j = 0; j < len; ++j) {
                    int cur = queue.poll();
                    visited[cur] = 1;
                    if (edgeMap.containsKey(cur)) {
                        for (int v : edgeMap.get(cur)) {
                            if (visited[v] == 0) {
                                queue.offer(v);
                            }
                        }
                    }
                }
            }
            ans.add(new int[]{i, height});
        }
        ans.sort(
            new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[1] - o2[1];
                }
            }
        );
        int minHeight = ans.get(0)[1];
        List<Integer> res = new ArrayList<>();
        for (int[] tmp: ans) {
            if (tmp[1] == minHeight) {
                res.add(tmp[0]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LC310 lc310 = new LC310();
        int n = 4;
        int[][] edges = new int[][]{{1,0},{1,2},{1,3}};
        System.out.println(lc310.findMinHeightTrees(n, edges));
    }

}
