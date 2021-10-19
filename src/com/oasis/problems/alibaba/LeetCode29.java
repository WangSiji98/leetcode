package com.oasis.problems.alibaba;

import com.oasis.datastructure.ListNode;

/**
 * 两数相除，[−2^31,  2^31 − 1], 全部转成负数比较好
 * 这题再研究下 转化成负数的做法
 */

public class LeetCode29 {

    /**
     * @param dividend 被除数
     * @param divisor 除数
     * @return 除法结果
     */
    // 不用long
    public int divide1(int dividend, int divisor) {
        // 被除数边界
        if (dividend == Integer.MAX_VALUE) {
            if (divisor == Integer.MIN_VALUE) {
                return 0;
            }
        } else if (dividend == Integer.MIN_VALUE) {
            if (divisor == 1) {
                return Integer.MIN_VALUE;
            } else if (divisor == -1) {
                // 除法结果溢出 Integer.MAX_VALUE + 1
                return Integer.MAX_VALUE;
            }
        }

        // 除数边界
        if (divisor == Integer.MIN_VALUE) {
            if (dividend != Integer.MIN_VALUE) {
                return 0;
            }
        } else if (divisor == 0) {
            // 除数为0，溢出
            return Integer.MAX_VALUE;
        }

        // 全部转成 负数，防止溢出
        boolean isPositive = true;
        if (dividend > 0) {
            dividend = -dividend;
            isPositive = false;
        }

        if (divisor > 0) {
            divisor = -divisor;
            isPositive = !isPositive;
        }

        // 开始二分法查找 设被除数为X，除数为Y，我们实际就是要找 X = res x Y
        // 由于 X Y 都是负数，且都要小于 -1;
        // 我们要找的就是 第一个 Z 使得 Z x Y < X
        // 模板就是套用二分的模板，
        int left = 0, right = Math.abs(dividend) + 1;

        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (quickMultiply(mid, divisor) == dividend) {
                return mid;
            } else if (quickMultiply(mid, divisor) > dividend) {
                left = mid + 1;
            } else {
                // l最终的结果就是第一个小于等于target的数字
                right = mid - 1;
            }
        }
        if (quickMultiply(right, divisor) < dividend) {
            --right;
        }
        return isPositive ? right : -right;
    }


    // 这是用long的
    public int divide(int dividend, int divisor) {

        // 被除数边界
        if (dividend == Integer.MAX_VALUE) {
            if (divisor == Integer.MIN_VALUE) {
                return 0;
            }
        } else if (dividend == Integer.MIN_VALUE) {
            if (divisor == 1) {
                return Integer.MIN_VALUE;
            } else if (divisor == -1) {
                // 除法结果溢出 Integer.MAX_VALUE + 1
                return Integer.MAX_VALUE;
            }
        }

        // 除数边界
        if (divisor == Integer.MIN_VALUE) {
            if (dividend != Integer.MIN_VALUE) {
                return 0;
            }
        } else if (divisor == 0) {
            // 除数为0，溢出
            return Integer.MAX_VALUE;
        }


        long divid = dividend;
        long divis = divisor;
        boolean isPositive = true;
        if (divisor < 0) {
            isPositive = false;
            divis = -divis;
        }
        if (dividend < 0) {
            isPositive = !isPositive;
            divid = -divid;
        }

        long l = 0, r = Math.abs(divid) + 1;
        while (l < r) {
            long mid = (l + r + 1) /2;
            // mid 依然有可能是 我们要找的数
            if (quickMultiply(divis, mid) <= divid) {
                l = mid;
            } else {
                // l最终的结果就是第一个比target小的数字
                r = mid - 1;
            }
        }


        return isPositive ? (int)r : (int)-r;
    }



    // 算 x * y
    public long quickMultiply(long x, long y) {
        long ans = 0;
        long contribute = y;
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
        LeetCode29 leetCode29 = new LeetCode29();
        System.out.println(leetCode29.divide(-2147483648, 2));
    }


}
