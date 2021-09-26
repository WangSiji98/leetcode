package com.oasis.problems.hot100;

public class LeetCode11 {
    public int maxArea(int[] height) {
        int n = height.length;
        int ans = 0;
        int left = 0, right = n - 1;
        int currentVol = 0;

        while (left < right) {
            currentVol = Math.min(height[left], height[right]) * (right - left);
            ans =  Math.max(currentVol, ans);
            if (height[left] >= height[right]) {
                --right;
            } else {
                ++left;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        LeetCode11 leetCode11 = new LeetCode11();
        int[] height = new int[]{4,3,2,1,4};
        System.out.println(leetCode11.maxArea(height));
    }
}
