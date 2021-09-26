package com.oasis.problems.hot100;

public class LeetCode647 {
    private int res = 0;
    private char[] chArray = null;
    private int len = 0;

    public int countSubstrings(String s) {
        len = s.length();
        if (len == 1) {
            return 1;
        }
        chArray = s.toCharArray();
        for (int i = 0; i < len - 1; ++i) {
            check(i, i);
            if (chArray[i] == chArray[i + 1]) {
                check(i, i + 1);
            }
        }
        check(len - 1, len - 1);
        return res;
    }

    private void check(int index1, int index2) {
        while (index1 >= 0 && index2 < len) {
            if (chArray[index1] == chArray[index2]) {
                ++res;
                --index1;
                ++index2;
            } else {
                return;
            }
        }
    }

    public static void main(String[] args) {
        LeetCode647 leetCode647 = new LeetCode647();
        String s = "aaa";
        System.out.println(leetCode647.countSubstrings(s));
    }

}
