package com.oasis.problems.baidu;

// 二分法逼近 根号2
public class sqrtTwo {
    
    public static double getSqrt(int x) {
        double step = 0.000000001;;
        double left = 0;
        double right = x;
        while(right >= left) {
            double mid = left + (right - left) / 2.0;
            double temp = mid * mid;
            if(Math.abs(temp - x) <= step) {
                return mid;
            } else if(temp > x) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return right;
    }

    public static void main(String[] args) {
        System.out.println(String.format("%.7f", getSqrt(2)));
    }
}
