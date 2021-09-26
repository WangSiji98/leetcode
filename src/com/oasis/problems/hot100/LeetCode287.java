package com.oasis.problems.hot100;

public class LeetCode287 {
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        int res = 0;
        for (int i = 0; i < n; ++i) {
            int index = nums[i] % (n - 1);
            nums[index] += (n - 1);
        }
        for (int i = 0; i < n - 1; ++i) {
            if (nums[i] > 2 * (n - 1)) {
                res = i;
                break;
            }
        }
        return res == 0 ? res + n - 1 : res;
    }

    public static void main(String[] args) {
        LeetCode287 leetCode287 = new LeetCode287();
        int[] nums = new int[]{1, 1};
        System.out.println(leetCode287.findDuplicate(nums));
    }


}
