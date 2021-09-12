package com.oasis.problems.amazon;

import com.oasis.datastructure.UnionFind;

public class LeetCode130UF {
    public static int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private UnionFind unionFind = null;
    private int m, n;

    public void solve(char[][] board) {
        m = board.length;
        n = board[0].length;
        // unionFind[m * n] 设置为所有边界的父节点
        unionFind = new UnionFind(m * n + 1);
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (board[i][j] == 'O') {
                    if (i == 0 || j == 0 || i == m - 1 || j == n - 1) {
                        unionFind.union(index(i, j), m * n);
                    } else {
                        for (int k = 0; k < 4; ++k) {
                            int iNew = i + dir[k][0];
                            int jNew = j + dir[k][1];
                            if (checkBorder(iNew, jNew) && board[iNew][jNew] == 'O') {
                                unionFind.union(index(i, j), index(iNew, jNew));
                            }
                        }
                    }
                }
            }
        }

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (! unionFind.isConnected(index(i, j), m * n)) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private int index(int i, int j) {
        return i * n + j;
    }

    private boolean checkBorder(int i, int j) {
        return i >= 0 && j >= 0 && i < m && j < n;
    }

    public static void main(String[] args) {
        LeetCode130 leetCode130 = new LeetCode130();
        char[][] board = new char[][]{
            {'X', 'X', 'X', 'X'},
            {'X', 'O', 'O', 'X'},
            {'X', 'X', 'O', 'X'},
            {'X', 'O', 'X', 'X'}
        };
        leetCode130.solve(board);
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                System.out.print(board[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
