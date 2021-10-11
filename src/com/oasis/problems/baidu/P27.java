package com.oasis.problems.baidu;

public class P27 {

    // 包含 target (target存在）
    // mid不加1，此时区间划分为[l, mid] 和 [mid + 1, r]
    public static int binarySearch3(int nums[], int target) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) >> 1;
            // mid 依然有可能是 我们要找的数
            if (nums[mid] >= target) {
                r = mid;
            } else {
                // l最终的结果就是第一个比target大的数字
                l = mid + 1;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5,6,7,8,10,11,11,12,13,14,15};
        int target = 11;
        // 找到第一个11
        System.out.println(binarySearch3(nums, target));
    }

}
