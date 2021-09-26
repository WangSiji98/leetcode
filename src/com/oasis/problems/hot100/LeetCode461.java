package com.oasis.problems.hot100;

public class LeetCode461 {
    public int hammingDistance(int x, int y) {
        int s = x ^ y, res = 0;
        while (s != 0) {
            res += s & 1;
            s >>= 1;
        }
        return res;
    }

    // Brian Kernighan 算法
    // 记 f(x) 表示 xx 和 x-1 进行与运算所得的结果（即 f(x) = x & (x-1)，那么 f(x) 恰为 x 删去其二进制表示中最右侧的 1 的结果。
    public int hammingDistance1(int x, int y) {
        int s = x ^ y, ret = 0;
        while (s != 0) {
            s &= s - 1;
            ret++;
        }
        return ret;
    }

}
