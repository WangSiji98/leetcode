package com.oasis.problems.amazon.oa;

/**
 * LC829
 */

public class OA12_2 {
    public int consecutiveNumbersSum(int n) {
        int res = 1;
        for (int i = 2; i < Math.sqrt(2 * n); ++i) {
            if ((n - i * (i - 1) / 2) % i == 0) {
                ++res;
            }
        }
        return res;
    }

}
