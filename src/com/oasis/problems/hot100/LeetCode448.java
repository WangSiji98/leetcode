package com.oasis.problems.hot100;

import java.util.ArrayList;
import java.util.List;

public class LeetCode448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            int index = nums[i] % n;
            nums[index] += n;
        }
        for (int i = 0; i < n; ++i) {
            if (nums[i] <= n) {
                res.add(i == 0 ? n : i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode448 leetCode448 = new LeetCode448();
        int[] nums = new int[]{2, 2};
        System.out.println(leetCode448.findDisappearedNumbers(nums));
    }
}
