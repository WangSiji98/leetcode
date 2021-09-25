package com.oasis.problems.amazon;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class LeetCode694 {
    private Set<String> set = new HashSet<>();
    private static int[][] dir = new int[][]{
        {1, 0},
        {0, 1},
        {-1, 0},
        {0, -1}
    };
    private int m, n;

    public int numDistinctIslands(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        m = grid.length;
        n = grid[0].length;

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 1) {
                    Queue<int[]> queue = new LinkedList<>();
                    queue.add(new int[]{i, j});
                    List<int[]> ans = new LinkedList<>();
                    int leftMax = n - 1, upMax = m - 1;
                    while (!queue.isEmpty()) {
                        int[] cur = queue.poll();
                        ans.add(cur);
                        leftMax = Math.min(leftMax, cur[1]);
                        upMax = Math.min(upMax, cur[0]);
                        for (int k = 0; k < 4; ++k) {
                            int x = cur[0] + dir[k][0];
                            int y = cur[1] + dir[k][1];
                            if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 1) {
                                grid[x][y] = 0;
                                queue.add(new int[]{x, y});
                            }
                        }
                        grid[cur[0]][cur[1]] = 0;
                    }
                    Collections.sort(
                        ans,
                        new Comparator<int[]>() {
                            @Override
                            public int compare(int[] o1, int[] o2) {
                                if (o1[0] == o2[0]) {
                                    return o1[1] - o2[1];
                                } else {
                                    return o1[0] - o2[0];
                                }
                            }
                        }
                    );
                    StringBuilder stringBuilder = new StringBuilder();
                    for (int[] coor: ans) {
                        stringBuilder.append(coor[0] - upMax);
                        stringBuilder.append(coor[1] - leftMax);
                    }
                    if (!set.contains(stringBuilder.toString())) {
                        set.add(stringBuilder.toString());
                    }
                }
            }
        }
        return set.size();
    }

    public static void main(String[] args) {
        LeetCode694 leetCode694 = new LeetCode694();
//        int[][] grid = new int[][]{
//            {1,1,0,1,1},
//            {1,0,0,0,0},
//            {0,0,0,0,1},
//            {1,1,0,1,1}
//        };
        int[][] grid = new int[][]{
            {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
        };
        System.out.println(leetCode694.numDistinctIslands(grid));
        for (int[] k: grid) {
            for (int i: k) {
                System.out.print(i);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

}
