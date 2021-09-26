package com.oasis.problems.hot100;

public class LeetCode169 {
    public int majorityElement(int[] nums) {
        int candidate = 0;
        int count = 0;
        for (int num: nums) {
            if (count == 0) {
                candidate = num;
            }
            count = count + (candidate == num ? 1: -1);
        }
        return candidate;
    }

    public static void main(String[] args) {
        LeetCode169 leetCode169 = new LeetCode169();
        int[] nums = new int[]{6, 5, 5};
        System.out.println(leetCode169.majorityElement(nums));
    }
}
