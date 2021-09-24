package com.oasis.problems.amazon;

public class LeetCode277 {
    private int n;

    public int findCelebrity(int n) {
        int cur = 0;
        this.n = n;
        for (int i = 0; i < n; ++i) {
            if (i == cur) {
                continue;
            }
            if (knows(cur, i)) {
                cur = i;
            }
        }
        return check(cur) ? cur : - 1;
    }

    boolean check(int k) {
        for (int i = 0; i < n; ++i) {
            if (i == k) {
                continue;
            }
            if (!knows(i, k) || knows(k, i)) {
                return false;
            }
        }
        return true;
    }

    private boolean knows(int a, int b) {
        return a > b;
    }
}
