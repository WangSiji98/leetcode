package com.oasis.problems.amazon.leetcode;

public class LeetCode45 {
    // 贪心 不是 dp
    public int jump(int[] nums) {
        int n = nums.length;
        int steps = 0;
        int right = 0;
        int maxPosition = 0;
        // 题目假设我们一定能跳到最后一个位置，所以nums[n - 2] >= 1
        for (int i = 0; i < n - 1; ++i) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (i == right) {
                ++steps;
                right = maxPosition;
            }
        }
        return steps;
    }

    public static void main(String[] args) {
        LeetCode45 leetCode45 = new LeetCode45();
        int[] nums = new int[]{1,1,1,1,1};
        System.out.println(leetCode45.jump(nums));
    }

}
