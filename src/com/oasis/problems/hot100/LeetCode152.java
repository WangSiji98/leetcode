package com.oasis.problems.hot100;

public class LeetCode152 {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int max = nums[0], min = nums[0], res = nums[0], maxTmp = 0, minTmp = 0;
        for (int i = 1; i < n; ++i) {
            maxTmp = max;
            minTmp = min;
            max = Math.max(nums[i], Math.max(nums[i] * maxTmp, nums[i] * minTmp));
            min = Math.min(nums[i], Math.min(nums[i] * minTmp, nums[i] * maxTmp));
            res = Math.max(res, max);
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode152 leetCode152 = new LeetCode152();
        int[] nums = new int[]{2,3,-2,4};
        System.out.println(leetCode152.maxProduct(nums));
    }
}
