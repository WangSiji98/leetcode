package com.oasis.problems.hot100;

public class LeetCode75 {
    public void sortColors(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return;
        }
        int p0 = 0, p1 = 0;
        for (int i = 0; i < n; ++i) {
            if (nums[i] == 0) {
                swap(nums, i, p0);
                if (p0 < p1) {
                    swap(nums, i, p1);
                }
                ++p0;
                ++p1;
                continue;
            }
            if (nums[i] == 1) {
                swap(nums, i, p1);
                ++p1;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        LeetCode75 leetCode75 = new LeetCode75();
        int[] nums = new int[]{2,0,2,1,1,0};
        leetCode75.sortColors(nums);
        for (int num: nums) {
            System.out.println(num);
        }
    }
}
