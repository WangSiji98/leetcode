package com.oasis.problems.amazon;

import java.util.Arrays;

public class LeetCode1465 {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        long hMax = Integer.MIN_VALUE;
        long vMax = Integer.MIN_VALUE;

        int mod = 1000000007;

        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);

        int m = horizontalCuts.length;
        int n = verticalCuts.length;

        for (int i = 1; i < m; ++i) {
            hMax = Math.max(hMax, horizontalCuts[i] - horizontalCuts[i - 1]);
        }
        hMax = Math.max(Math.max(hMax, horizontalCuts[0]), h - horizontalCuts[m - 1]);

        for (int i = 1; i < n; ++i) {
            vMax = Math.max(vMax, verticalCuts[i] - verticalCuts[i - 1]);
        }
        vMax = Math.max(Math.max(vMax, verticalCuts[0]), w - verticalCuts[n - 1]);


        return (int) ((hMax * vMax) % mod);
    }

    public static void main(String[] args) {
        LeetCode1465 leetCode1465 = new LeetCode1465();
        int h = 5;
        int w = 4;
        int[] horizontalCuts = new int[]{3, 1};
        int[] verticalCuts = new int[]{1 };
        System.out.println(leetCode1465.maxArea(h, w, horizontalCuts, verticalCuts));
    }

}
