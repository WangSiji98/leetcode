package com.oasis.problems.amazon;

public class LeetCode39 {
    public boolean isValidSudoku(char[][] board) {
        int[][] row = new int[9][9];
        int[][] col = new int[9][9];
        int[][] block = new int[9][9];

        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                if (board[i][j] == '.') {
                    continue;
                }
                int num = board[i][j] - '1';
                int index = (i/3) * 3 + j/3;
                if (row[i][num] == 0 && col[j][num] == 0 && block[index][num] == 0) {
                    ++row[i][num];
                    ++col[j][num];
                    ++block[index][num];
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
