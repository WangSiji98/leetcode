package com.oasis.problems.amazon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class LeetCode1091 {
    private int m, n;
    private int max = Integer.MAX_VALUE;

    private static int[][] dir = new int[][]{
        {0, 1},
        {-1, 1},
        {-1, 0},
        {-1, -1},
        {0, -1},
        {1, -1},
        {1, 0},
        {1, 1}
    };

    public int shortestPathBinaryMatrix(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        if (grid[0][0] == 1) {
            return -1;
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        int min = Integer.MAX_VALUE;
        int len = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            ++len;
            for (int l = 0; l < size; ++l) {
                int[] curr = queue.poll();
                int i = curr[0];
                int j = curr[1];
                if (grid[i][j] == 1) {
                    continue;
                }
                if (i == n -1 && j == m -1) {
                    min = Math.min(min, len);
                    continue;
                }
                for (int k = 0; k < 8; ++k) {
                    int newI = i + dir[k][0];
                    int newJ = j + dir[k][1];
                    if (newI >= 0 && newI < m && newJ >= 0 && newJ < n && grid[newI][newJ] == 0) {
                        queue.offer(new int[]{newI, newJ});
                    }
                }
                grid[i][j] = 1;
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }


    public static void main(String[] args) {
        LeetCode1091 leetCode1091 = new LeetCode1091();
        int[][] grid = new int[][]{
            {0,0,0},
            {1,1,0},
            {1,1,0}
        };
        System.out.println(leetCode1091.shortestPathBinaryMatrix(grid));
    }

}
