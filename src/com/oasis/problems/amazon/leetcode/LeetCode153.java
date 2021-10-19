package com.oasis.problems.amazon.leetcode;

public class LeetCode153 {
    // 旋转数组的二分查找 非常经典
    public int findMin(int[] nums) {
        int n = nums.length;
        int left = 0, right = n - 1;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (nums[mid] <= nums[n - 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return nums[left];
    }

    public static void main(String[] args) {
        LeetCode153 leetCode153 = new LeetCode153();
        int[] nums = new int[]{4, 5, 6, 7, 1, 3};
        System.out.println(leetCode153.findMin(nums));
    }

}
