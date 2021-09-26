package com.oasis.problems.hot100;

// 比特位计数
// tips: 对于任意整数 xx，令 x=x&(x-1)，该运算将 xx 的二进制表示的最后一个 1 变成 0。

public class LeetCode338 {
    // 最低有效位置
    public int[] countBits1(int n) {
        int[] bits = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            bits[i] = bits[i >> 1] + (i & 1);
        }
        return bits;
    }

    // 最低设置位
    public int[] countBits2(int n) {
        int[] bits = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            bits[i] = bits[i & (i - 1)] + 1;
        }
        return bits;
    }

    // Brian Kernighan 算法
    // 对于任意整数 xx，令 x=x&(x-1)，该运算将 xx 的二进制表示的最后一个 1 变成 0。
    public int countOnes(int x) {
        int ones = 0;
        while (x > 0) {
            x &= (x - 1);
            ones++;
        }
        return ones;
    }
}
