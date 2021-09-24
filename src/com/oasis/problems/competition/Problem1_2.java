package com.oasis.problems.competition;

public class Problem1_2 {
    public int sumOfBeauties(int[] nums) {
        int n = nums.length;
        int[] max = new int[n];
        int[] min = new int[n];

        min[n - 1] = nums[n - 1];
        max[0] = nums[0];

        int res = 0;

        for (int i = n - 2; i > 0; --i) {
            min[i] = Math.min(min[i + 1], nums[i + 1]);
        }
        for (int i = 1; i <= n - 2; ++i) {
            max[i] = Math.max(max[i - 1], nums[i - 1]);
            if (max[i] < nums[i] && min[i] > nums[i]) {
                res += 2;
            } else if (nums[i - 1] < nums[i] && nums[i + 1] > nums[i]) {
                res += 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Problem1_2 problem1_2 = new Problem1_2();
        int[] nums = new int[]{1, 2, 3};
        System.out.println(problem1_2.sumOfBeauties(nums));
    }

}
