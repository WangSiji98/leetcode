package com.oasis.problems.hot100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class LeetCode207 {
    private Map<Integer, List<Integer>> edge = null;
    private int[] inDegree = null;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        edge = new HashMap<>();
        inDegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            edge.put(i, new ArrayList<>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            edge.get(prerequisites[i][1]).add(prerequisites[i][0]);
            ++inDegree[prerequisites[i][0]];
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i< numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }
        int numTake = 0;
        while (!queue.isEmpty()) {
            ++ numTake;
            int u = queue.remove();
            for (int v: edge.get(u)) {
                --inDegree[v];
                if (inDegree[v] == 0) {
                    queue.add(v);
                }
            }
        }

        return numTake == numCourses;
    }

    public static void main(String[] args) {
        LeetCode207 leetCode207 = new LeetCode207();
        int numCourse = 2;
        int[][] prerequisites = new int[][]{{1, 0}};
        System.out.println(leetCode207.canFinish(numCourse, prerequisites));
    }
}
