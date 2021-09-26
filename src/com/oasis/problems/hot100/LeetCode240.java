package com.oasis.problems.hot100;

public class LeetCode240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int i = m - 1, j = 0;
        while (i >= 0 && j < n) {
            if (matrix[i][j] == target) {
                return true;
            }
            if (matrix[i][j] < target) {
                ++j;
            } else {
                --i;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        LeetCode240 leetCode240 = new LeetCode240();
        int[][] matrix = new int[][]{{1,4,7,11,15}, {2,5,8,12,19}, {3,6,9,16,22}, {10,13,14,17,24}, {18,21,23,26,30}};
        int target = 5;
        System.out.println(leetCode240.searchMatrix(matrix, target));
    }
}
