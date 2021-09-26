package com.oasis.problems.hot100;

public class LeetCode34 {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int[] res = new int[]{-1, -1};
        if (n < 1) {
            return res;
        }
        int l = 0, r = n - 1;

        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        if (nums[r] != target) {
            return res;
        } else {
            res[0] = r;
        }
        l = 0;
        r = n - 1;
        while (l < r) {
            int mid = (l + r + 1) / 2;
            if (nums[mid] <= target) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        res[1] = r;
        return res;
    }

    public static void main(String[] args) {
        LeetCode34 leetCode34 = new LeetCode34();
        int[] nums = new int[0];
        int target = 0;
        int[] res = leetCode34.searchRange(nums, target);
        System.out.println(res[0]);
        System.out.println(res[1]);
    }
}
