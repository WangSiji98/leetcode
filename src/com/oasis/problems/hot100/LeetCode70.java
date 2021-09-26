package com.oasis.problems.hot100;

public class LeetCode70 {
    public int climbStairs(int n) {
        if (n <= 1) {
            return 1;
        }
        int p = 1;
        int q = 1;
        int r = 0;
        for (int i = 2; i <= n; ++i) {
            r = p + q;
            q = p;
            p = r;
        }
        return r;
    }

    public static void main(String[] args) {
        LeetCode70 leetCode70 = new LeetCode70();
        int n = 3;
        System.out.println(leetCode70.climbStairs(n));
    }

}
