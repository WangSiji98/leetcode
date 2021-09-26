package com.oasis.problems.hot100;

import java.util.Arrays;

public class LeetCode238 {

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = 1;
        for (int i = 1; i < n; ++i) {
            left[i] = left[i - 1] * nums[i - 1];
        }
        right[n - 1] = 1;
        for (int i = n - 2; i >= 0; --i) {
            right[i] = right[i + 1] * nums[i + 1];
        }
        int[] res = new int[n];
        for (int i = 0; i < n; ++i) {
            res[i] = left[i] * right[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4};
        LeetCode238 leetCode238 = new LeetCode238();
        System.out.println(Arrays.toString(leetCode238.productExceptSelf(nums)));
    }
}
