package com.oasis.problems.amazon.vo;

import java.util.ArrayList;
import java.util.List;

public class LC1905 {

    private static int[][] directions = new int[][]{
        {1, 0},
        {0, 1},
        {-1, 0},
        {0, -1}
    };

    private List<List<int[]>> islands = new ArrayList<>();

    private int indexOfIslands = 0;
    private int m, n;

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        if (grid1.length == 0 || grid1[0].length == 0) {
            return 0;
        }
        m = grid1.length;
        n = grid1[0].length;

        int res = 0;

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid2[i][j] == 1) {
                    islands.add(new ArrayList<int[]>());
                    dfs(grid2, i, j ,indexOfIslands);
                    boolean isInIslande1 = true;
                    for (int[] land: islands.get(indexOfIslands)) {
                        if (grid1[land[0]][land[1]] == 0) {
                            isInIslande1 = false;
                            break;
                        }
                    }
                    if (isInIslande1) {
                        ++res;
                    }
                    ++indexOfIslands;
                }
            }
        }
        return res;
    }

    private void dfs(int[][] grid2, int i, int j, int index) {
        islands.get(index).add(new int[]{i, j});
        grid2[i][j] = 0;
        for (int k = 0; k < 4; ++k) {
            int newI = i + directions[k][0];
            int newJ = j + directions[k][1];
            if (newI >= 0 && newI < m && newJ >=0 && newJ < n && grid2[newI][newJ] == 1) {
                dfs(grid2, newI, newJ, index);
            }
        }
    }

    public static void main(String[] args) {
        int[][] grid1 = new int[][]{{1,1,1,1,0,0},{1,1,0,1,0,0},{1,0,0,1,1,1},{1,1,1,0,0,1},{1,1,1,1,1,0},{1,0,1,0,1,0},{0,1,1,1,0,1},{1,0,0,0,1,1},{1,0,0,0,1,0},{1,1,1,1,1,0}};
        int[][] grid2 = new int[][]{{1,1,1,1,0,1},{0,0,1,0,1,0},{1,1,1,1,1,1},{0,1,1,1,1,1},{1,1,1,0,1,0},{0,1,1,1,1,1},{1,1,0,1,1,1},{1,0,0,1,0,1},{1,1,1,1,1,1},{1,0,0,1,0,0}};
        LC1905 lc1905 = new LC1905();
        System.out.println(lc1905.countSubIslands(grid1, grid2));
    }



}
