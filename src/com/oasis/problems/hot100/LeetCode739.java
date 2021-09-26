package com.oasis.problems.hot100;

import java.util.Arrays;
import java.util.Stack;

public class LeetCode739 {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];
        Stack<Integer> stk = new Stack<>();
        for (int i = 0; i < n; ++i) {
            if (stk.isEmpty() || temperatures[i] <= temperatures[stk.peek()]) {
                stk.add(i);
            } else {
                while (!stk.isEmpty() && temperatures[i] > temperatures[stk.peek()]) {
                    Integer tmp = stk.pop();
                    res[tmp] = i - tmp;
                }
                stk.add(i);
            }
        }
        return res;

    }

    public static void main(String[] args) {
        LeetCode739 leetCode739 = new LeetCode739();
        int[] temperatures = new int[]{73,74,75,71,69,72,76,73};
        System.out.println(Arrays.toString(leetCode739.dailyTemperatures(temperatures)));
    }

}
