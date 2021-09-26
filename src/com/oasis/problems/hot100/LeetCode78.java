package com.oasis.problems.hot100;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LeetCode78 {
    private List<List<Integer>> res;
    private List<Integer> ans;

    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return Collections.emptyList();
        }
        res = new ArrayList<>();
        ans = new ArrayList<>();
        backTrack(nums, 0);
        return res;
    }

    private void backTrack(int[] nums, int index) {
        if (index == nums.length) {
            res.add(new ArrayList<>(ans));
            return;
        }
        backTrack(nums, index + 1);
        ans.add(nums[index]);
        backTrack(nums, index + 1);
        ans.remove(ans.size() - 1);
    }

    public static void main(String[] args) {
        LeetCode78 leetCode78 = new LeetCode78();
        int[] nums = new int[]{1, 2, 3};
        System.out.println(leetCode78.subsets(nums));
    }
}
