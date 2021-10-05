package com.oasis.problems.amazon.oa;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * LC 992 HARD
 *
 * Given an integer array nums and an integer k, return the number of good subarrays of nums.
 *
 * A good array is an array where the number of different integers in that array is exactly k.
 *
 * For example, [1,2,3,1,2] has 3 different integers: 1, 2, and 3.
 * A subarray is a contiguous part of an array.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,1,2,3], k = 2
 * Output: 7
 * Explanation: Subarrays formed with exactly 2 different integers: [1,2], [2,1], [1,2], [2,3], [1,2,1], [2,1,2], [1,2,1,2]
 * Example 2:
 *
 * Input: nums = [1,2,1,3,4], k = 3
 * Output: 3
 * Explanation: Subarrays formed with exactly 3 different integers: [1,2,1,3], [2,1,3], [1,3,4].
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 2 * 104
 * 1 <= nums[i], k <= nums.length
 */

public class OA10_1 {
    private Map<Integer, Integer> map = new HashMap<>();

    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMostKDistinct(nums, k) - atMostKDistinct(nums, k - 1);
    }

    private int atMostKDistinct(int[] nums, int k) {
        map.clear();
        if (k == 0) {
            return 0;
        }
        int n  = nums.length;
        int left = 0;
        int right = 0;
        int res = 0;

        while (right < n) {
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            ++right;

            while (left <= right && map.size() > k) {
                if (map.get(nums[left]) == 1) {
                    map.remove(nums[left]);
                } else {
                    map.put(nums[left], map.get(nums[left]) - 1);
                }
                ++left;
            }
            res += right - left;
        }
        return res;
    }

    public static void main(String[] args) {
        OA10_1 oa10_1 = new OA10_1();
        int[] nums = new int[]{1,2,1,2,3};
        int k = 2;
        System.out.println(oa10_1.subarraysWithKDistinct(nums, k));
    }

}
