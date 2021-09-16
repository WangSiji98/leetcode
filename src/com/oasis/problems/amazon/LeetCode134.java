package com.oasis.problems.amazon;

public class LeetCode134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int i = 0;
        int start = 0;
        int curGas;
        while (start < n) {
            i = start;
            curGas = gas[i];
            while (curGas >= cost[i]) {
                curGas = curGas - cost[i] + gas[(i + 1) % n];
                i = (i + 1) % n;
                if (i == start) {
                    return start;
                }
            }
            if (i < start) {
                return -1;
            }
            start = i + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        LeetCode134 leetCode134 = new LeetCode134();
        int[] gas = new int[]{1, 2, 3, 4, 5};
        int[] cost = new int[]{3, 4, 5, 1, 2};
        System.out.println(leetCode134.canCompleteCircuit(gas, cost));
    }

 }
