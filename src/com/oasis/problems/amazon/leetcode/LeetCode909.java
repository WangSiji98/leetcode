package com.oasis.problems.amazon.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode909 {
    private int n = 6;
    int step;
    int[] visited;

    public int snakesAndLadders(int[][] board) {
        n = board.length;
        visited = new int[n * n];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        step = 0;
        while (!queue.isEmpty()) {
            ++step;
            int size = queue.size();
            for (int k = 0; k < size; ++k) {
                int cur = queue.poll();
                for (int i = 1; i <= 6; ++i) {
                    if (cur + i > n * n) {
                        break;
                    }
                    if (cur + i == n * n) {
                        return step;
                    }
                    int[] pos = getCoor(cur + i);
                    if (visited[cur + i - 1] == 0) {
                        visited[cur + i - 1] = 1;
                        if (board[pos[0]][pos[1]] == -1) {
                            queue.offer(cur + i);
                        } else {
                            if (board[pos[0]][pos[1]] == n * n) {
                                return step;
                            }
                            queue.offer(board[pos[0]][pos[1]]);
                        }
                    }
                }
            }
        }
        return -1;
    }

    private int[] getCoor(int index) {
        int x, y;
        if (index % n == 0) {
            y = index / n - 1;
            if (y % 2 == 0) {
                x = n - 1;
            } else {
                x = 0;
            }
        } else {
            y = index / n;
            if (y % 2 == 0) {
                x = index % n - 1;
            } else {
                x = n - index % n;
            }
        }
        return new int[]{n - 1 - y, x};
    }

    public static void main(String[] args) {
        LeetCode909 leetCode909 = new LeetCode909();
        int[][] board = new int[][]{
            {-1,-1,-1,-1,-1,-1},
            {-1,-1,-1,-1,-1,-1},
            {-1,-1,-1,-1,-1,-1},
            {-1,35,-1,-1,13,-1},
            {-1,-1,-1,-1,-1,-1},
            {-1,15,-1,-1,-1,-1},
        };
        System.out.println(leetCode909.snakesAndLadders(board));
//        System.out.println(Arrays.toString(leetCode909.getCoor(17)));
    }

}
