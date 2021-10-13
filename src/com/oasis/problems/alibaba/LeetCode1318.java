package com.oasis.problems.alibaba;

public class LeetCode1318 {
    public int minFlips(int a, int b, int c) {

        int res = 0;

        for (int i = 0; i < 32; ++i) {
            int ai = a & (1 << i);
            int bi = b & (1 << i);
            int ci = c & (1 << i);
            if ((ai | bi) == ci) {
                continue;
            } else {
                if (ci == 0) {
                    if (ai != bi) {
                        ++res;
                    } else {
                        res += 2;
                    }
                } else {
                    ++res;
                }
            }

        }
        return res;

    }

    public static void main(String[] args) {
        int a = 2;
        int b = 6;
        int c = 5;

        LeetCode1318 leetCode1318 = new LeetCode1318();

        System.out.println(leetCode1318.minFlips(a, b, c));
    }

}
