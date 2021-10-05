package com.oasis.problems.amazon.oa;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * LC 1135
 *
 * 最小生成树算法 Prim 或者 Kruskal 算法
 */

class Prim {
    
    private Map<Integer, List<int[]>> map = new HashMap<>(); 
    private Set<Integer> set = new HashSet<>();
    
    public int minimumCost(int n, int[][] connections) {
        for (int[] edge: connections) {
            for (int i = 0; i < 2; ++i) {
                if (!map.containsKey(edge[i])) {
                    map.put(edge[i], new ArrayList<>());
                }
            }
            map.get(edge[0]).add(edge);
            map.get(edge[1]).add(new int[]{edge[1], edge[0], edge[2]});
        }
        int verNum = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[2] - o2[2];
                }
            }
        );
        int cost = 0;
        ++verNum;
        set.add(1);
        for (int[] edge: map.get(1)) {
            pq.add(edge);
        }
        while (verNum < n && !pq.isEmpty()) {
            int[] curEdge = pq.poll();
            if (set.contains(curEdge[0]) && set.contains(curEdge[1])) {
                continue;
            } else {
                cost += curEdge[2];
            }
            for (int i = 0; i < 2; ++i) {
                int vertex = curEdge[i];
                if (!set.contains(vertex)) {
                    ++verNum;
                    set.add(vertex);
                    if (verNum == n) {
                        return cost;
                    }
                    for (int[] adj: map.get(vertex)) {
                        pq.add(adj);
                    }
                }
            }
        }
        return -1;
    }
}

class Kruskal {
    
    public int minimumCost(int n, int[][] connections) {
        return 0;

    }
}

class UnionFindKruskal {

    public int minimumCost(int n, int[][] connections) {
        return 0;

    }
}

// MST
public class OA8_2 {

    public static void main(String[] args) {
        Prim prim = new Prim();
        int n = 3;
        int[][] connections = new int[][]{
            {1, 2, 5},
            {1, 3, 6},
            {2, 3, 1}
        };
        System.out.println(prim.minimumCost(n, connections));
    }

}
