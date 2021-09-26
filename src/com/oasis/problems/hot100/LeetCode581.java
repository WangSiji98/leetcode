package com.oasis.problems.hot100;

public class LeetCode581 {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return 0;
        }
        // 上下边界
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = 1; i < n; ++i) {
            if (nums[i] < nums[i - 1]) {
                min = Math.min(min, nums[i]);
                max = Math.max(max, nums[i - 1]);
            }
        }
        int left = 0, right = n - 1;
        while (left < n) {
            if (nums[left] < min) {
                ++left;
            } else {
                break;
            }
        }
        while (right >= 0) {
            if (nums[right] > max) {
                --right;
            } else {
                break;
            }
        }
        return Math.max(0, right - left + 1);

    }

    public static void main(String[] args) {
        LeetCode581 leetCode581 = new LeetCode581();
        int[] nums = new int[]{2,6,4,8,10,9,15};
        System.out.println(leetCode581.findUnsortedSubarray(nums));
    }

}
