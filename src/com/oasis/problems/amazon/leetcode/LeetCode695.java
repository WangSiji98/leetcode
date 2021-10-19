package com.oasis.problems.amazon.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode695 {
    private static int[][] dir = new int[][]{
        {1, 0},
        {0, 1},
        {-1, 0},
        {0, -1}
    };
    private int m, n;

    public int maxAreaOfIsland(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int ans = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 1) {
                    int num = 0;
                    Queue<int[]> queue = new LinkedList<>();
                    queue.offer(new int[]{i, j});
                    grid[i][j] = 0;
                    ++num;
                    while (!queue.isEmpty()) {
                        int[] cur = queue.poll();
                        for (int k = 0; k < 4; ++k) {
                            int newI = cur[0] + dir[k][0];
                            int newJ = cur[1] + dir[k][1];
                            if (newI >= 0 && newI < m && newJ >= 0 && newJ < n && grid[newI][newJ] == 1) {
                                queue.offer(new int[]{newI, newJ});
                                grid[newI][newJ] = 0;
                                ++num;
                            }
                        }
                    }
                    ans = Math.max(ans, num);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        LeetCode695 leetCode695 = new LeetCode695();
        int[][] grid = new int[][]{
            {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
            {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
            {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
        };
        System.out.println(leetCode695.maxAreaOfIsland(grid));
    }

}
