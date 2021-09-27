package com.oasis.problems.amazon.oa;

import java.util.Arrays;

/**
 * 题目见word文档 11 图片
 *
 * 给一个int[]，需要按照要求对它进行改造：1. 第一个数必须是1  ｜ 2. 对相邻两数，后一个数减前一个数不能大于1；问：这样改造过后array末尾元素的最大值是多少？
 */

public class OA6_1 {
    public int maxValue(int[] nums) {
        Arrays.sort(nums);
        int last = nums[0];
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] - last > 1) {
                nums[i] = last + 1;
            }
            last = nums[i];
        }
        return nums[nums.length - 1];
    }

    public static void main(String[] args) {
        OA6_1 oa6_1 = new OA6_1();
        int[] nums = new int[]{2, 1, 3, 4};
        System.out.println(oa6_1.maxValue(nums));
    }

}
