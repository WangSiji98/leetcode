package com.oasis.problems.amazon.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 带染色的dfs，如果在 dfs 碰到了 未完成搜索的节点，则意味着存在环，判断图是否有环的一种办法
public class LeetCode210DFS {
    List<List<Integer>> pre;
    int[] state;
    int[] res;
    int index;
    boolean ring = false;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        pre = new ArrayList<>();
        for (int i = 0; i < numCourses; ++i) {
            pre.add(new ArrayList<Integer>());
        }
        state = new int[numCourses];
        for (int[] edge: prerequisites) {
            pre.get(edge[0]).add(edge[1]);
        }
        res = new int[numCourses];
        index = 0;
        for (int i = 0; i < numCourses; ++i) {
            if (state[i] == 0) {
                dfs(i);
            }
        }
        return ring ? new int[]{} : res;
    }

    private void dfs(int cur) {
        state[cur] = 1;
        for (int prev: pre.get(cur)) {
            if (state[prev] == 0) {
                dfs(prev);
                if (ring) {
                    return;
                }
            } else if (state[prev] == 1) {
                ring = true;
                return;
            }
        }
        state[cur] = 2;
        res[index] = cur;
        ++index;
    }

    public static void main(String[] args) {
        LeetCode210DFS leetCode210DFS = new LeetCode210DFS();
        int numCourses = 4;
        int[][] prerequisites = new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        System.out.println(Arrays.toString(leetCode210DFS.findOrder(numCourses, prerequisites)));
    }

}
