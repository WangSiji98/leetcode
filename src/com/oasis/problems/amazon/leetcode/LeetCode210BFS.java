package com.oasis.problems.amazon.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCode210BFS {
    List<List<Integer>> edges;
    int[] inDegree;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        edges = new ArrayList<>();
        for (int i = 0; i < numCourses; ++i) {
            edges.add(new ArrayList<Integer>());
        }
        inDegree = new int[numCourses];
        for (int[] edge: prerequisites) {
            ++inDegree[edge[0]];
            edges.get(edge[1]).add(edge[0]);
        }
        Queue<Integer> queue = new LinkedList<>();
        int[] res = new int[numCourses];
        int index = 0;
        for (int i = 0; i < numCourses; ++i) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            res[index] = cur;
            ++index;
            for (int v: edges.get(cur)) {
                --inDegree[v];
                if (inDegree[v] == 0) {
                    queue.add(v);
                }
            }
        }
        return index == numCourses ? res : new int[]{};
    }

    public static void main(String[] args) {
        LeetCode210BFS leetCode210BFS = new LeetCode210BFS();
        int numCourses = 4;
        int[][] prerequisites = new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        System.out.println(Arrays.toString(leetCode210BFS.findOrder(numCourses, prerequisites)));
    }

}
