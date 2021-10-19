package com.oasis.problems.amazon.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode229 {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        int candidate1 = -1, candidate2 = -1;
        int count1 = 0, count2 = 0;
        for (int num: nums) {
            if (count1 > 0 && num == candidate1) {
                ++count1;
            } else if (count2 > 0 && num == candidate2) {
                ++count2;
            } else if (count1 == 0) {
                candidate1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                candidate2 = num;
                count2 = 1;
            } else {
                --count1;
                --count2;
            }
        }
        // check if it's really over 1/3
        count1 = 0;
        count2 = 0;
        for (int num: nums) {
            if (num == candidate1) {
                ++count1;
            } else if (num == candidate2) {
                ++count2;
            }
        }
        List<Integer> res = new ArrayList<>();
        if (count1 > n / 3) {
            res.add(candidate1);
        }
        if (count2 > n / 3) {
            res.add(candidate2);
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode229 leetCode229 = new LeetCode229();
        int[] nums = new int[]{1,1,1,3,3,2,2,2};
        System.out.println(leetCode229.majorityElement(nums));
    }
}
