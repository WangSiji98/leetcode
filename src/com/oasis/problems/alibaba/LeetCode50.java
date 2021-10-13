package com.oasis.problems.alibaba;

public class LeetCode50 {

    // 快速幂算法
    // 递归算法，易于理解，但效率较低
    public double myPow(double x, int n) {
        long N = n;
        return N >= 0 ? quickMul2(x, N) : 1.0 / quickMul2(x, -N);
    }

    public double quickMul1(double x, long N) {
        if (N == 0) {
            return 1.0;
        }
        double y = quickMul1(x, N / 2);
        return N % 2 == 0 ? y * y : y * y * x;
    }

    // 整数的二进制拆分
    public double quickMul2(double x, long N) {
        double ans = 1.0;
        double x_contribute = x;
        while (N > 0) {
            // 对应的二进制位数为1的时候计算贡献
            if (N % 2 == 1) {
                ans *= x_contribute;
            }
            x_contribute *= x_contribute;
            N /= 2;
        }
        return ans;
    }

}
