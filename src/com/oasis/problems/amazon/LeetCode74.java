package com.oasis.problems.amazon;

public class LeetCode74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        int i = row - 1;
        int j = 0;
        while (i >= 0 && j < col) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] > target) {
                --i;
            } else {
                ++j;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        LeetCode74 leetCode74 = new LeetCode74();
        int[][] matrix = new int[][]{
            {1, 3, 5, 7},
            {10, 11, 16, 20},
            {20, 30, 34, 60},
        };
        System.out.println(leetCode74.searchMatrix(matrix, 3));
    }

}
