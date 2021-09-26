package com.oasis.problems.hot100;

import java.util.ArrayList;
import java.util.List;

public class LeetCode32 {
    public int longestValidParentheses(String s) {
        int n = s.length();
        int ans = 0;
        if (n < 2) {
            return 0;
        }
        List<Integer> dp = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            dp.add(i, 0);
        }
        for (int i = 0; i < n - 1; ++i) {
            if (s.charAt(i) == '(' && s.charAt(i + 1) == ')') {
                if (i < 1) {
                    dp.set(i + 1, 2);
                    ans = 2;
                    continue;
                }
                dp.set(i + 1, dp.get(i - 1) + 2);
                ans = Math.max(ans, dp.get(i + 1));
            }
            if (s.charAt(i) == ')' && s.charAt(i + 1) == ')') {
                if (i + 1 - dp.get(i) - 1 >= 0 && s.charAt(i + 1 - dp.get(i) - 1) == '(') {
                    dp.set(i + 1, dp.get(i) + 2);
                    if (i + 1 - dp.get(i) - 2 >= 0) {
                        dp.set(i + 1, dp.get(i + 1) + dp.get(i + 1 - dp.get(i) - 2));
                    }

                    ans = Math.max(ans, dp.get(i + 1));
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        LeetCode32 leetCode32 = new LeetCode32();
        String s = "(()())";
        System.out.println(leetCode32.longestValidParentheses(s));
    }
}
