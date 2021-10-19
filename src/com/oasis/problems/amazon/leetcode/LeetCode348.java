package com.oasis.problems.amazon.leetcode;

// 尚未debug完成
public class LeetCode348 {
    /**
     * Your TicTacToe object will be instantiated and called as such:
     * TicTacToe obj = new TicTacToe(n);
     * int param_1 = obj.move(row,col,player);
     */
    class TicTacToe {
        private int[][] board;

        /** Initialize your data structure here. */
        public TicTacToe(int n) {
            board = new int[3][3];
        }

        /** Player {player} makes a move at ({row}, {col}).
         @param row The row of the board.
         @param col The column of the board.
         @param player The player, can be either 1 or 2.
         @return The current winning condition, can be either:
         0: No one wins.
         1: Player 1 wins.
         2: Player 2 wins. */
        public int move(int row, int col, int player) {
            board[row][col] = player == 1 ? 1 : -1;
            return check() ? player : 0;
        }

        private boolean check() {
            for (int i = 0; i < 3; ++i) {
                if (Math.abs(board[i][0] + board[i][1] + board[i][2]) == 3) {
                    return true;
                }
                if (Math.abs(board[0][i] + board[i][1] + board[i][2]) == 3) {
                    return true;
                }
            }
            if (Math.abs(board[0][0] + board[1][1] + board[2][2]) == 3 || Math.abs(board[2][0] + board[1][1] + board[0][2]) == 3) {
                return true;
            }
            return false;
        }
    }


}
