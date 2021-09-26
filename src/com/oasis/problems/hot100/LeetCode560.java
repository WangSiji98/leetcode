package com.oasis.problems.hot100;

import java.util.HashMap;
import java.util.Map;

public class LeetCode560 {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        if (n == 0) {
            return 0;
        }
        int[] prev = new int[n + 1];
        prev[0] = 0;
        map.put(prev[0], 1);
        int res = 0;
        for (int i = 1; i <= n; ++i) {
            prev[i] = prev[i - 1] + nums[i - 1];
            res += map.getOrDefault(prev[i] - k, 0);
            map.put(prev[i], map.getOrDefault(prev[i], 0) + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode560 leetCode560 = new LeetCode560();
        int[] nums = new int[]{1};
        int k = 0;
        System.out.println(leetCode560.subarraySum(nums, k));
    }
}
