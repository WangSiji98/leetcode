package com.oasis.problems.hot100;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class LeetCode494 {
    private int res = 0;
    private int target = 0;

    public int findTargetSumWays(int[] nums, int target) {
        this.target = target;
        int n = nums.length;
        dfs(nums, 0, 0);
        return this.res;
    }

    public void dfs(int[] nums, int index, int cur) {
        if (index == nums.length) {
            if (cur == this.target) {
                ++this.res;
            }
            return;
        }
        dfs(nums, index + 1, cur + nums[index]);
        dfs(nums, index + 1, cur - nums[index]);
    }

    public static void main(String[] args) {
        LeetCode494 leetCode494 = new LeetCode494();
        int[] nums = new int[]{1, 1, 1, 1, 1};
        int target = 3;
        System.out.println(leetCode494.findTargetSumWays(nums, target));
    }

}
