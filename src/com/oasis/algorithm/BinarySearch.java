package com.oasis.algorithm;

// 二分查找的两种模板
public class BinarySearch {
    // mid不加1，此时区间划分为[l, mid] 和 [mid + 1, r]
    // 我们要找的是 比target大的第一个数 (即使target存在)
    public static int binarySearch1(int nums[], int target) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) >> 1;
            // mid 依然有可能是 我们要找的数
            if (nums[mid] > target) {
                r = mid;
            } else {
                // l最终的结果就是第一个比target大的数字
                l = mid + 1;
            }
        }
        return nums[r];
    }

    // mid加1，此时区间划分为[l, mid - 1] 和 [mid, r]
    // 我们要找的是 比target小的第一个数 (即使target存在)
    public static int binarySearch2(int nums[], int target) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (l + r + 1) >> 1;
            // mid 依然有可能是 我们要找的数
            if (nums[mid] < target) {
                l = mid;
            } else {
                // l最终的结果就是第一个比target小的数字
                r = mid - 1;
            }
        }
        return nums[l];
    }


    // 如果需要包含 target (target存在）
    // 第一个大于等于target的数字
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
        return nums[r];
    }

    // 第一个小于等于target的数
    public static int binarySearch4(int nums[], int target) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (l + r + 1) >> 1;
            // mid 依然有可能是 我们要找的数
            if (nums[mid] <= target) {
                l = mid;
            } else {
                // l最终的结果就是第一个比target小的数字
                r = mid - 1;
            }
        }
        return nums[l];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5,6,7,8,10,11,11,12,13,14,15};
        int target = 11;
        // 找到第一个比11大的数
        System.out.println(binarySearch1(nums, target));
        // 找到第一个比11小的数
        System.out.println(binarySearch2(nums, target));
        // 找到第一个大于等于11的数
        System.out.println(binarySearch3(nums, target));
        // 找到第一个小于等于11的数
        System.out.println(binarySearch4(nums, target));
    }

}
