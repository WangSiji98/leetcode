package com.oasis.problems.baidu;

/**
 * 只包含012数字的数组，进行排序
 *
 * 著名的荷兰国旗问题
 */

public class SortColor {

    // 换0和1
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

    // 换0和2
    public void sortColors2(int[] nums) {
        int n = nums.length;
        int p0 = 0, p2 = n - 1;
        for (int i = 0; i <= p2; ++i) {
            while (i <= p2 && nums[i] == 2) {
                swap(nums, i, p2);
                --p2;
            }
            if (nums[i] == 0) {
                swap(nums, i, p0);
                ++p0;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
