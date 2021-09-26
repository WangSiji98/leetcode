package com.oasis.problems.hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class LeetCode399 {
    static class UnionFind {
        public int[] parent;
        private double[] weight;

        public UnionFind(int n){
            parent = new int[n];
            weight = new double[n];
            for (int i = 0; i < n; ++i) {
                parent[i] = i;
                weight[i] = 1.0d;
            }
        }

        public int find(int x) {
            if (x != parent[x]) {
                int tmp = parent[x];
                parent[x] = find(parent[x]);
                weight[x] *= weight[tmp];
            }
            return parent[x];
        }

        public void union(int x, int y, double v) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return;
            }
            parent[rootX] = rootY;
            weight[rootX] = weight[y] * v / weight[x];
        }

        public double check(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return weight[x] / weight[y];
            }
            return -1.0d;
        }
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int n = equations.size();
        UnionFind unionFind = new UnionFind(2 * n);
        Map<String, Integer> map = new HashMap<>(2 * n);
        int index = 0;
        for (int i = 0; i < n; ++i) {
            List<String> equation = equations.get(i);
            String x = equation.get(0);
            String y = equation.get(1);

            if (!map.containsKey(x)) {
                map.put(x, index);
                ++index;
            }

            if (!map.containsKey(y)) {
                map.put(y, index);
                ++index;
            }
            unionFind.union(map.get(x), map.get(y), values[i]);
        }

        int m = queries.size();
        double[] res = new double[m];
        for (int i = 0; i < m; ++i) {
            String x = queries.get(i).get(0);
            String y = queries.get(i).get(1);

            Integer idx = map.get(x), idy = map.get(y);

            if (Objects.isNull(idx) || Objects.isNull(idy)) {
                res[i] = -1.0d;
            } else {
                res[i] = unionFind.check(idx, idy);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode399 leetCode399 = new LeetCode399();
        List<List<String>> equations = new ArrayList<List<String>>(){{
           add(Arrays.asList("a", "b"));
           add(Arrays.asList("b", "c"));
        }};
        double[] values = new double[]{2.0, 3.0};
        List<List<String>> queries = new ArrayList<List<String>>(){{
            add(Arrays.asList("a", "c"));
            add(Arrays.asList("b", "a"));
            add(Arrays.asList("a", "e"));
            add(Arrays.asList("a", "a"));
            add(Arrays.asList("x", "x"));
        }};
        System.out.println(Arrays.toString(leetCode399.calcEquation(equations, values, queries)));
    }
}

