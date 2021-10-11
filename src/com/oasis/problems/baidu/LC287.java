package com.oasis.problems.baidu;

/**
 * 给定一个包含n + 1 个整数的数组nums ，其数字都在 1 到 n之间（包括 1 和 n），可知至少存在一个重复的整数。
 *
 * 假设 nums 只有 一个重复的整数 ，找出 这个重复的数 。
 *
 * 你设计的解决方案必须不修改数组 nums 且只用常量级 O(1) 的额外空间。
 */
public class LC287 {
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        int res = 0;
        for (int i = 0; i < n; ++i) {
            int index = nums[i] % (n - 1);
            nums[index] += (n - 1);
        }
        for (int i = 0; i < n - 1; ++i) {
            if (nums[i] > 2 * (n - 1)) {
                res = i;
                break;
            }
        }
        return res == 0 ? res + n - 1 : res;
    }

}
