package com.oasis.problems.hot100;

public class LeetCode42 {
    public int trap(int[] height) {
        int n = height.length;
        int[] left = new int[n];
        int[] right = new int[n];

        int leftMax = Integer.MIN_VALUE;
        int rightMax = Integer.MIN_VALUE;
        for (int i = 0; i < n; i ++) {
            leftMax = Math.max(leftMax, height[i]);
            left[i] = leftMax;
            int j = n - i - 1;
            rightMax = Math.max(rightMax, height[j]);
            right[j] = rightMax;
        }
        left[0] = height[0];
        right[n - 1] = height[n - 1];
        int vol = 0;
        for (int i = 0; i < n; ++i) {
            vol += Math.min(left[i], right[i]) - height[i];
        }
        return vol;
    }

    public static void main(String[] args) {
        LeetCode42 leetCode42 = new LeetCode42();
        int[] height = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(leetCode42.trap(height));
    }
}
