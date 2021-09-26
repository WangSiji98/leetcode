package com.oasis.problems.hot100;

import java.util.Objects;

public class LeetCode198 {
    public int rob(int[] nums) {
        if (nums == null) {
            return 0;
        }
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return nums[0];
        }
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        LeetCode198 leetCode198 = new LeetCode198();
        int[] nums = new int[]{2,7,9,3,1};
        System.out.println(leetCode198.rob(nums));
    }

}
