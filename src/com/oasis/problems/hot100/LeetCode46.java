package com.oasis.problems.hot100;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LeetCode46 {
    private List<List<Integer>> res;
    private List<Integer> ans;

    public List<List<Integer>> permute(int[] nums) {
        if (nums.length < 1) {
            return Collections.emptyList();
        }
        res = new ArrayList<>();
        ans = new ArrayList<>();
        backTrack(nums, 0);
        return res;
    }

    private void backTrack(int[] nums, int index) {
        if (index == nums.length) {
            List<Integer> tmp = new ArrayList<>(ans);
            res.add(tmp);
        }
        for (int i = index; i < nums.length; i++) {
            ans.add(nums[i]);
            swap(nums, index, i);
            backTrack(nums, index + 1);
            ans.remove(ans.size() - 1);
            swap(nums, i, index);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        LeetCode46 leetCode46 = new LeetCode46();
        int[] nums = new int[]{1, 2, 3};
        System.out.println(leetCode46.permute(nums));
    }
}
