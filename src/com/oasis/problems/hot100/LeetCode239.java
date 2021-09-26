package com.oasis.problems.hot100;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Iterator;

public class LeetCode239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new ArrayDeque<>();
        int n = nums.length;
        int[] res = new int[n - k + 1];

        for (int i = 0; i < k; ++i) {
            if (!deque.isEmpty() && deque.getLast() < nums[i]) {
                while (!deque.isEmpty() && deque.getLast() < nums[i]) {
                    deque.removeLast();
                }
            }
            deque.addLast(nums[i]);
        }

        for (int i = k; i < n; ++i) {
            res[i - k] = deque.getFirst();
            if (deque.getLast() < nums[i]) {
                while (!deque.isEmpty() && deque.getLast() < nums[i]) {
                    deque.removeLast();
                }
            }
            deque.addLast(nums[i]);
            if (nums[i - k] == deque.getFirst() || deque.size() > k) {
                deque.removeFirst();
            }
        }
        res[n - k] = deque.getFirst();
        return res;
    }

    public static void main(String[] args) {
        LeetCode239 leetCode239 = new LeetCode239();
        int[] nums = new int[]{1,3,-1,-3,5,3,6,7};
        int k = 3;
        System.out.println(Arrays.toString(leetCode239.maxSlidingWindow(nums, k)));
    }


}
