package com.oasis.problems.hot100;

import java.util.Arrays;

public class LeetCode283 {
    public void moveZeroes(int[] nums) {
        int j = 0;
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            if (nums[i] != 0) {
                swap(nums, i, j);
                ++j;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        LeetCode283 leetCode283 = new LeetCode283();
        int[] nums = new int[]{0,1,0,3,12};
        leetCode283.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}
