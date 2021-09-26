package com.oasis.problems.hot100;

// 一种简单的系统
public class LeetCode300 {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < n; ++i) {
            dp[i] = 1;
            for (int j = 0; j < i; ++j) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode300 leetCode300 = new LeetCode300();
        int[] nums = new int[]{10,9,2,5,3,7,101,18};
        System.out.println(leetCode300.lengthOfLIS(nums));
    }
}
