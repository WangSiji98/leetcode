package com.oasis.problems.hot100;

import java.util.Arrays;
import java.util.Map;

public class LeetCode416 {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return false;
        }
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for(int num: nums) {
            sum += num;
            max = Math.max(max, num);
        }
        if (sum % 2 == 1) {
            return false;
        }
        int target = sum / 2;
        if (max > target) {
            return false;
        }
        boolean[][] dp = new boolean[n][target + 1];
        for (int i = 0; i < n; ++i) {
            dp[i][0] = true;
        }
        for (int i = 1; i < n; ++i) {
            for (int j = 1; j <= target; ++j) {
                if (j < nums[i]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                }
            }
        }
        return dp[n - 1][target];
    }

    public static void main(String[] args) {
        LeetCode416 leetCode416 = new LeetCode416();
        int[] nums = new int[]{1,5,11,5};
        System.out.println(leetCode416.canPartition(nums));
    }

}
