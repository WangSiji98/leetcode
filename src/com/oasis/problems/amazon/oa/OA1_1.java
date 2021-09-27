package com.oasis.problems.amazon.oa;

import java.util.Arrays;

/**
 * 1.Find the minimum length of the roof that covers K cars.You are given an List of positions of cars as to where they are parked. You are also given an integer K.
 *
 * The cars needs to be covered with a roof. You have to find the minimum length of roof that takes to cover K cars.
 *
 * Input : 12,6,5,2      K = 3
 *
 * Explanation :  There are two possible roofs that can cover K cars. One that covers the car in 2,5,6 parking spots and
 * another roof which covers 5,6,12 parking spots. The length of these two roofs are 5 and 8 respectively. Return 5
 * since that's the roof with minimum length that covers K cars.
 *
 * Output : 5
 *
 * https://leetcode.com/discuss/interview-question/1317796/amazon-oa-2021-hackerrank
 */

public class OA1_1 {
    public int minCover(int[] pos, int k) {
        int n = pos.length;
        if (n == 0) {
            return 0;
        }
        // 升序
        Arrays.sort(pos);

        if (n <= k) {
            return pos[n - 1] - pos[0] + 1;
        }

        int left = 0, right = k - 1;
        int ans = pos[right] - pos[left] + 1;
        for (int i = k; i < n; ++i) {
            ans = Math.min((pos[i] - pos[i - k + 1] + 1), ans);
        }
        return ans;
    }

    public static void main(String[] args) {
        OA1_1 oa1_1 = new OA1_1();
        int[] pos = new int[]{12,6,5,2};
        int k = 3;
        System.out.println(oa1_1.minCover(pos, k));
    }

}
