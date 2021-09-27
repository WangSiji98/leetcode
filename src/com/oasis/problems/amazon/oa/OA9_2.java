package com.oasis.problems.amazon.oa;

/**
 * Throttling Gateway Hackerrank/Citadel
 *
 * https://leetcode.com/discuss/interview-question/819577/Throttling-Gateway-Hackerrank
 */

class Solution9_2 {
    public int gateway(int[] requestTime) {
        int droppedNum = 0;

        for (int i = 0; i < requestTime.length; ++i) {
            if (i > 2 && requestTime[i] - requestTime[i - 3] == 0) {
                ++droppedNum;
            } else if (i > 19 && requestTime[i] - requestTime[i - 20] < 10) {
                ++droppedNum;
            } else if (i > 59 && requestTime[i] - requestTime[i - 60] < 60) {
                ++droppedNum;
            }
        }
        return droppedNum;
    }
}

public class OA9_2 {
    public static void main(String[] args) {
        Solution9_2 solution9_2 = new Solution9_2();
        int[] requestTime = new int[]{1,1,1,1,2,2,2,3,3,3,4,4,4,5,5,5,6,6,6,7,7,7,7,11,11,11,11};
        System.out.println(solution9_2.gateway(requestTime));
    }
}
