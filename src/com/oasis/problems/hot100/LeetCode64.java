package com.oasis.problems.hot100;

public class LeetCode64 {
//    public int minPathSum(int[][] grid) {
//        Stack<int[]> stk = new Stack<>();
//        int min = Integer.MAX_VALUE;
//        int n = grid.length;
//        int m = grid[0].length;
//        int ans = 0;
//
//        stk.add(new int[]{0, 0});
//        while (!stk.isEmpty()) {
//            int[] cur = stk.pop();
//            ans += grid[cur[1]][cur[0]];
//            if (cur[0] == m - 1 && cur[1] == n - 1) {
//                min = Math.min(min, ans);
//            } else {
//                if (cur[0] + 1 < m) {
//                    stk.add(new int[]{cur[0] + 1, cur[1]});
//                }
//                if (cur[1] + 1 < n) {
//                    stk.add(new int[]{cur[0], cur[1] + 1});
//                }
//            }
//            ans -= grid[cur[0]][cur[1]];
//        }
//        return min;
//    }

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

    public static void main(String[] args) {
        LeetCode64 leetCode64 = new LeetCode64();
        int[][] grid = new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(leetCode64.minPathSum(grid));
    }
}
