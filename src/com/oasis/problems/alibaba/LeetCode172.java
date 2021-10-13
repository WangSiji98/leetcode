package com.oasis.problems.alibaba;

/**
 * 阶乘后的0
 * 其实就是计算阶乘中5的个数
 */

public class LeetCode172 {
    public int trailingZeroes(int n) {
        int zeroCount = 0;
        long currentMultiple = 5;
        while (n > 0) {
            n /= 5;
            zeroCount += n;
        }
        return zeroCount;
    }
}
