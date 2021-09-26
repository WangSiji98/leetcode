package com.oasis.problems.hot100;

public class LeetCode55 {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int max = nums[0];
        int i = 1;
        while (i <= max && i < n) {
            max = Math.max(max, i + nums[i]);
            ++i;
        }
        return i == n;
    }

    public static void main(String[] args) {
        LeetCode55 leetCode55 = new LeetCode55();
        int[] nums = new int[]{3, 2, 1, 0, 4};
        System.out.println(leetCode55.canJump(nums));
    }
}
