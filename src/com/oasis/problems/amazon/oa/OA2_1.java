package com.oasis.problems.amazon.oa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一组数字和一个固定区间，要求将数字分组，每个组内数字的落差不超出区间范围，求最少有几个分组。例如，[1，2，3，4], 区间=2，则最少有2组，[1,2,3],[4]。
 *
 * 我感觉是 greedy
 */

public class OA2_1 {
    public List<List<Integer>> splitArrays(int[] nums, int range) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        int start = nums[0] - range - 1;
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            if (nums[i] - start > range) {
                if (!ans.isEmpty()) {
                    res.add(ans);
                }
                ans = new ArrayList<>();
                ans.add(nums[i]);
                start = nums[i];
            } else {
                ans.add(nums[i]);
            }
        }
        res.add(ans);
        return res;
    }

    public static void main(String[] args) {
        OA2_1 oa2_1 = new OA2_1();
        int[] nums = new int[]{1, 3,4,5, 9};
        for (List<Integer> list : oa2_1.splitArrays(nums, 2)) {
            System.out.println(list);
        }
    }

}
