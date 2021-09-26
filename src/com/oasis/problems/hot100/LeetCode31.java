package com.oasis.problems.hot100;

import java.util.Arrays;

public class LeetCode31 {
        public void nextPermutation(int[] nums) {
            int n = nums.length;
            if (n == 1) {
                return;
            }
            int i = n - 1;
            while (i > 0) {
                if (nums[i] <= nums[i - 1]) {
                    --i;
                } else {
                    break;
                }
            }
            // 特殊情况 直接反转数组
            if (i == 0) {
                Arrays.sort(nums);
                return;
            }
            if (i == n) {
                swap(nums, i, i - 1);
                return;
            }
            int j = i + 1;
            while (j < n) {
                if (nums[j] > nums[i - 1]) {
                    ++j;
                } else {
                    break;
                }
            }
            --j;
            swap(nums, i - 1, j);
            Arrays.sort(nums, i, n);
        }

        private void swap(int[] nums, int i, int j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }

    public static void main(String[] args) {
        LeetCode31 leetCode31 = new LeetCode31();
        int[] nums = new int[]{5, 1, 1};
        leetCode31.nextPermutation(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
}
