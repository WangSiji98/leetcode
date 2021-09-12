package com.oasis.problems.amazon;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.Stack;

public class LeetCode130 {
    public static int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private int m, n;

    public void solve(char[][] board) {
        m = board.length;
        n = board[0].length;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if ((i == 0 || j == 0 || i == m - 1 || j == n - 1) && board[i][j] == 'O') {
                    bfs(board, i, j);
                }
            }
        }
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == 'V') {
                    board[i][j] = 'O';
                }
            }
        }

    }

    private void bfs(char[][] board, int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});
        board[i][j] = 'V';
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int k = 0; k < 4; ++k) {
                int iNew = cur[0] + dir[k][0];
                int jNew = cur[1] + dir[k][1];
                if (iNew >= 0 && jNew >= 0 && iNew < m && jNew < n && board[iNew][jNew] == 'O') {
                    queue.add(new int[]{iNew, jNew});
                    board[iNew][jNew] = 'V';
                }
            }
        }
    }

    public static void main(String[] args) {
        LeetCode130 leetCode130 = new LeetCode130();
        char[][] board = new char[][]{
            {'O', 'O', 'O'},
            {'O', 'O', 'O'},
            {'O', 'O', 'O'},
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
