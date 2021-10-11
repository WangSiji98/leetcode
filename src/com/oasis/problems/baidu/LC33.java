package com.oasis.problems.baidu;

public class LC33 {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int l = 0;
        int r = n - 1;
        while (l <= r) {
            int mid = (l + r) >> 1;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > nums[n - 1]) {
                if (target > nums[n - 1] && nums[mid] > target) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                if (target <= nums[n - 1] && nums[mid] < target) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        LC33 lc33 = new LC33();
        int[] nums = new int[]{4,5,6,7,0,1,2};
        int target = 0;
        System.out.println(lc33.search(nums, target));
    }

}
