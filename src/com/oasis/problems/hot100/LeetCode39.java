package com.oasis.problems.hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode39 {
    private List<List<Integer>> res;
    private List<Integer> ans;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<>();
        ans = new ArrayList<>();
        Arrays.sort(candidates);
        backTrack(candidates, target, 0);
        return res;
    }

    private void backTrack(int[] candidates, int target, int index) {
        if (target == 0) {
            List<Integer> tmp = new ArrayList<>();
            tmp.addAll(ans);
            res.add(tmp);
            return;
        }
        if (target < 0) {
            return;
        }
        if (index >= candidates.length) {
            return;
        }
        int num = 1;
        backTrack(candidates, target, index + 1);
        while (num * candidates[index] <= target) {
            for (int i = 0; i < num; i++) {
                ans.add(candidates[index]);
            }
            backTrack(candidates, target - num * candidates[index], index + 1);
            for (int i = 0; i < num; i++) {
                ans.remove(ans.size() - 1);
            }
            ++num;
        }
    }

    public static void main(String[] args) {
        LeetCode39 leetCode39 = new LeetCode39();
        int[] candidates = new int[]{2, 3, 5};
        int target = 8;
        System.out.println(leetCode39.combinationSum(candidates, target));
    }
}
