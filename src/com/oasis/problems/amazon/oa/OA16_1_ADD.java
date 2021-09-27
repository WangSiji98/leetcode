package com.oasis.problems.amazon.oa;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Demolition Robot
 * Given a matrix with values 0 (trenches) , 1 (flat) , and 9 (obstacle) you have to find minimum distance to reach 9 (obstacle). If not possible then return -1.
 * The demolition robot must start at the top left corner of the matrix, which is always flat, and can move on block up, down, right, left.
 * The demolition robot cannot enter 0 trenches and cannot leave the matrix.
 * Sample Input :
 * [1, 0, 0],
 * [1, 0, 0],
 * [1, 9, 1]]
 * Sample Output :
 * 3
 * This question can be solved by using BFS or DFS.
 */

public class OA16_1_ADD {
    private static int[][] dir = new int[][]{
        {1, 0},
        {0, 1},
        {-1, 0},
        {0, -1}
    };

    public int robot(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }
        int minDis = Integer.MAX_VALUE;
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        int currDis = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            ++currDis;
            for (int i = 0; i < size; ++i) {
                int[] curr = queue.poll();
                int x = curr[0];
                int y = curr[1];
                for (int k = 0; k < 4; ++k) {
                    int newX = x + dir[k][0];
                    int newY = y + dir[k][1];
                    if (newX >= 0 && newX < m && newY >= 0 && newY < n && grid[newX][newY] != 0) {
                        if (grid[newX][newY] == 9) {
                            minDis = Math.min(minDis, currDis);
                            break;
                        }
                        queue.offer(new int[]{newX, newY});
                    }
                }
                grid[x][y] = 0;
            }
        }
        return minDis;
    }

    public static void main(String[] args) {
        OA16_1_ADD oa16_1_add = new OA16_1_ADD();
        int[][] grid = new int[][]{
            {1, 1, 1},
            {1, 0, 1},
            {0, 9, 1},
        };
        System.out.println(oa16_1_add.robot(grid));
    }
}
