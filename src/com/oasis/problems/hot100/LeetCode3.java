package com.oasis.problems.hot100;

import java.util.HashSet;
import java.util.Set;

public class LeetCode3 {
    public int lengthOfLongestSubstring(String s) {
        int right = -1;
        int ans = 0;
        int n = s.length();

        Set<Character> set = new HashSet<>();

        for (int i = 0; i < n; ++i) {
            if (i != 0) {
                set.remove(s.charAt(i - 1));
            }
            while (right + 1 < n && !set.contains(s.charAt(right + 1))) {
                set.add(s.charAt(right + 1));
                ++right;
            }

            ans = Math.max(ans, right - i + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        LeetCode3 leetCode3 = new LeetCode3();
        String s = "abcabcbb";
        System.out.println(leetCode3.lengthOfLongestSubstring(s));
    }

}
