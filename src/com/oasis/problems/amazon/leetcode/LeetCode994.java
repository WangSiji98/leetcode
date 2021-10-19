package com.oasis.problems.amazon.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode994 {
    private static int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private int m, n;

    public int orangesRotting(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        // 初始情况，把所有的腐烂的橘子加入进去
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                }
            }
        }

        int ans = -1;
        // 开始bfs，类似层序遍历的思路
        while (!queue.isEmpty()) {
            int len = queue.size();
            ++ans;
            for (int i = 0; i < len; ++i) {
                int[] cur = queue.poll();
                for (int k = 0; k < 4; ++k) {
                    int newX = cur[0] + dir[k][0];
                    int newY = cur[1] + dir[k][1];
                    if (newX >= 0 && newX < m && newY >= 0 & newY < n && grid[newX][newY] == 1) {
                        grid[newX][newY] = 2;
                        queue.add(new int[]{newX, newY});
                    }
                }
            }
        }
        boolean fresh = false;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 1) {
                   fresh = true;
                   break;
                }
            }
        }
        return fresh ? -1 : (Math.max(ans, 0));
    }

    public static void main(String[] args) {
        LeetCode994 leetCode994 = new LeetCode994();
        int[][] grid = new int[][]{{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        System.out.println(leetCode994.orangesRotting(grid));
    }
}
