package com.oasis.problems.hot100;

import java.util.HashMap;
import java.util.Map;

public class LeetCode1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i < nums.length; ++i) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }

    public static void main(String[] args) {
        LeetCode1 leetCode1 = new LeetCode1();
        int[] nums = new int[]{1, 2, 3, 28, 5};
        int target = 7;

        int[] result = leetCode1.twoSum(nums, target);
        for (int num: result) {
            System.out.println(num);
        }
    }

}
