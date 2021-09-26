package com.oasis.problems.hot100;

/*
含有冷冻期的股票买卖

在第i天分为3种情况：
1. 不在冷冻期内，且手上没有股票
2. 刚刚卖出股票，在冷冻期内
3. 手上有股票

转换关系是：
1 -> 3   1 -> 1
2 -> 1
3 -> 2   3 -> 3
 */

public class LeetCode309 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] hold = new int[n], freeze = new int[n], unhold = new int[n];
        hold[0] = -prices[0];
        freeze[0] = 0;
        unhold[0] = 0;
        for (int i = 1; i < n; ++i) {
            hold[i] = Math.max(unhold[i - 1] - prices[i], hold[i - 1]);
            freeze[i] = hold[i - 1] + prices[i];
            unhold[i] = Math.max(freeze[i - 1], unhold[i - 1]);
        }
        return Math.max(unhold[n - 1], freeze[n - 1]);
    }

    public static void main(String[] args) {
        LeetCode309 leetCode309 = new LeetCode309();
        int[] prices = new int[]{1,2,3,0,2};
        System.out.println(leetCode309.maxProfit(prices));
    }
}
