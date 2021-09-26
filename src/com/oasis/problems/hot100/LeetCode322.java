package com.oasis.problems.hot100;

import java.util.Arrays;
import java.util.Comparator;

public class LeetCode322 {
    public int coinChange(int[] coins, int amount) {
        int k = coins.length;
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for (int i = 1; i <= amount; ++i) {
            dp[i] = -1;
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < k; ++j) {
                if (i - coins[j] >= 0 && dp[i - coins[j]] != -1) {
                    min = Math.min(min, dp[i - coins[j]] + 1);
                }
                if (min != Integer.MAX_VALUE) {
                    dp[i] = min;
                }
            }
        }

        return dp[amount];
    }

    public static void main(String[] args) {
        LeetCode322 leetCode322 = new LeetCode322();
        int[] coins = new int[]{1, 2, 5};
        int amount = 11;
        System.out.println(leetCode322.coinChange(coins, amount));
    }

}
