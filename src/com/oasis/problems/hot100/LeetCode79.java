package com.oasis.problems.hot100;

public class LeetCode79 {
    private boolean[][] visited = null;
    private static int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private int m = 0;
    private int n = 0;

    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                boolean res = backTrack(board, word, 0, i, j);
                if (res) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backTrack(char[][] board, String word, int index, int i, int j) {
        if (board[i][j] != word.charAt(index)) {
            return false;
        } else if (index == word.length() - 1) {
            return true;
        }
        visited[i][j] = true;
        boolean res = false;
        for (int[] dir : dirs) {
            int iNew = i + dir[0], jNew = j + dir[1];
            if (iNew >= 0 && iNew < m && jNew >= 0 && jNew < n) {
                if (!visited[iNew][jNew]) {
                    boolean flag = backTrack(board, word, index + 1, iNew, jNew);
                    if (flag) {
                        res = true;
                        break;
                    }
                }
            }
        }
        visited[i][j] = false;
        return res;
    }

    public static void main(String[] args) {
        LeetCode79 leetCode79 = new LeetCode79();
        char[][] board = new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCCED";
        System.out.println(leetCode79.exist(board, word));

    }
}
