package com.oasis.problems.baidu;

/**
 * 最小路径和
 * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 *
 * 说明：每次只能向下或者向右移动一步。
 */

// 经典DP
public class LC64 {
    public int minPathSum(int[][] grid) {
        int min = Integer.MAX_VALUE;
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];
        dp[0][0] = grid[0][0];
        int ans = dp[0][0];
        for (int i = 1; i < n; ++i) {
            ans += grid[i][0];
            dp[i][0] = ans;
        }
        ans = dp[0][0];
        for (int i = 1; i < m; ++i) {
            ans += grid[0][i];
            dp[0][i] = ans;
        }
        for (int i = 1; i < n; ++i) {
            for (int j = 1; j < m; ++j) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[n - 1][m - 1];
    }

}
