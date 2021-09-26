package com.oasis.problems.hot100;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LeetCode128 {
    private int res = Integer.MIN_VALUE;
    private Set<Integer> set = null;

    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        set = new HashSet<>();
        for (int i = 0; i < n; ++i) {
            set.add(nums[i]);
        }
        for (int i = 0; i < n; ++i) {
            if (!set.contains(nums[i])) {
                continue;
            }
            int left = nums[i] - 1, right = nums[i] + 1;
            set.remove(nums[i]);
            while (set.contains(left)) {
                set.remove(left);
                --left;
            }
            while (set.contains(right)) {
                set.remove(right);
                ++right;
            }
            res = Math.max(res, right - left - 1);
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode128 leetCode128 = new LeetCode128();
        int[] nums = new int[]{100,4,200,1,3,2};
        System.out.println(leetCode128.longestConsecutive(nums));
    }
}
