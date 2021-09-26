package com.oasis.problems.hot100;

public class LeetCode279 {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; ++i) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; ++j) {
                min = Math.min(min, dp[i - j * j]);
            }
            dp[i] = min + 1;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        LeetCode279 leetCode279 = new LeetCode279();
        int n = 12;
        System.out.println(leetCode279.numSquares(n));
    }
}
