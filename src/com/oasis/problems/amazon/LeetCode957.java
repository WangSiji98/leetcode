package com.oasis.problems.amazon;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LeetCode957 {
//    private Map<Byte, Integer> map = new HashMap<>();

    public int[] prisonAfterNDays(int[] cells, int n) {
        int i = 0;
        int period = 0;
        Byte startState = 0;
        while (i < n) {
            ++i;
            cells = next(cells);
            if (i == 1) {
                startState = getState(cells);
            } else if (getState(cells).equals(startState)) {
                period = i - 1;
                i = n - (n - i) % period;
            }
        }
        return cells;
    }

    private Byte getState(int[] cells) {
        byte state = 0;
        // only encode 6 bits in the middle
        for (int i = 0; i < 6; ++i) {
            state ^= ((cells[i + 1] & 1) << i);
        }
        return state;
    }

    private int[] next(int[] cells) {
        int[] next = new int[8];
        for (int i = 1; i < 7; ++i) {
            next[i] = cells[i - 1] == cells[i + 1] ? 1 : 0;
        }
        return next;
    }

    public static void main(String[] args) {
        LeetCode957 leetCode957 = new LeetCode957();
        int[] cells = new int[]{1,0,0,1,0,0,1,0};
        int n = 1000000000;
        System.out.println(Arrays.toString(leetCode957.prisonAfterNDays(cells, n)));
    }
}
