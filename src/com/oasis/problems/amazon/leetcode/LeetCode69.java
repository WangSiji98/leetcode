package com.oasis.problems.amazon.leetcode;

public class LeetCode69 {
    // 非常朴实无华的二分查找
    public int mySqrt(int x) {
        int l = 0, r = x, ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if ((long) mid * mid <= x) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }

    // 牛顿法
    // x_i+1 = 0.5 * (x_i + C / x_i)
    public int mySqrt1(int x) {
        if (x == 0 || x == 1) {
            return x;
        }
        double C = x, x0 = x;
        while (true) {
            double xi = 0.5 * (x0 + C / x0);
            if (Math.abs(xi - x0) < 1e-8) {
                break;
            }
            x0 = xi;
        }
        return (int)x0;
    }

    public static void main(String[] args) {
        LeetCode69 leetCode69 = new LeetCode69();
        int x = 8;
        System.out.println(leetCode69.mySqrt(x));
    }

}
