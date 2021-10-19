package com.oasis.algorithm;

public class QucikAlgorithm {

    public double myPow(double x, int n) {
        long N = n;
        return N >= 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);
    }

    // 整数的二进制拆分
    public double quickMul(double x, long N) {
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

    // 快速乘法，用加法算
    public static int quickMultiply(int x, int y) {
        int ans = 0;
        int contribute = y;
        while (x > 0) {
            // 对应的二进制位数为1的时候计算贡献
            if (x % 2 == 1) {
                ans += contribute;
            }
            contribute += contribute;
            x /= 2;
        }
        return ans;
    }

    public static void main(String[] args) {
        int x = -5;
        int y = 6;
        System.out.println(QucikAlgorithm.quickMultiply(y, x));

    }

}
