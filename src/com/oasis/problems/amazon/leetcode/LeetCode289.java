package com.oasis.problems.amazon.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LeetCode289 {

    /*
    0 - 死
    1 - 活
    2 - 原来是活的，但因为周围的活细胞少于2个 现在死了
    3 - 原来是活的吗，因为周围的活细胞2或3个，现在依然活着
    4 - 原来活着，现在周围的活细胞多于3个，现在死了
    5 - 原来死了，周围活细胞恰好3个，复活了
    6 - 原来死的，现在还是死的
     */

    private static Map<Integer, Integer> next = new HashMap<Integer, Integer>(){{
        put(2, 0);
        put(3, 1);
        put(4, 0);
        put(5, 1);
        put(6, 0);
    }};

    private static Map<Integer, Integer> last = new HashMap<Integer, Integer>(){{
        put(2, 1);
        put(3, 1);
        put(4, 1);
        put(5, 0);
        put(6, 0);
    }};

    private static int[][] dir = new int[][]{
        {0, 1},
        {-1, 1},
        {-1, 0},
        {-1, -1},
        {0, -1},
        {1, -1},
        {1, 0},
        {1, 1},
    };

    private int m, n;

    public void gameOfLife(int[][] board) {
        m = board.length;
        n = board[0].length;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                int numOfAlive = countAlive(board, i, j);
                if (board[i][j] == 0) {
                    if (numOfAlive == 3) {
                        board[i][j] = 5;
                    } else {
                        board[i][j] = 6;
                    }
                } else {
                    if (numOfAlive < 2) {
                        board[i][j] = 2;
                    } else if (numOfAlive > 3) {
                        board[i][j] = 4;
                    } else {
                        board[i][j] = 3;
                    }
                }
            }
        }

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                board[i][j] = next.get(board[i][j]);
            }
        }
    }

    private int countAlive(int[][] board, int i, int j) {
        int numOfAlive = 0;
        for (int k = 0; k < 8; ++k) {
            int newI = i + dir[k][0];
            int newJ = j + dir[k][1];
            if (newI >= 0 && newI < m && newJ >= 0 && newJ < n) {
                if (board[newI][newJ] == 1 || last.getOrDefault(board[newI][newJ], -1) == 1) {
                    ++numOfAlive;
                }
            }
        }
        return numOfAlive;
    }

    public static void main(String[] args) {
        LeetCode289 leetCode289 = new LeetCode289();
        int[][] board = new int[][]{
            {0, 1, 0},
            {0, 0, 1},
            {1, 1, 1},
            {0 , 0, 0},
        };
        leetCode289.gameOfLife(board);
        for (int i = 0; i < board.length; ++i) {
            System.out.println(Arrays.toString(board[i]));
        }
    }
}
