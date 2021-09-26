package com.oasis.problems.hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LeetCode438 {
    public List<Integer> findAnagrams(String s, String p) {
        int lenp = p.length();
        int lens = s.length();
        if (lenp > lens) {
            return Collections.emptyList();
        }
        List<Integer> res = new ArrayList<>();
        int[] source = new int[26];
        int[] target = new int[26];

        for (int i = 0; i < lenp; ++i) {
            ++target[p.charAt(i) - 'a'];
            ++source[s.charAt(i) - 'a'];
        }
        if (Arrays.equals(source, target)) {
            res.add(0);
        }
        for (int i = lenp; i < lens; ++i) {
            ++source[s.charAt(i) - 'a'];
            --source[s.charAt(i - lenp) - 'a'];
            if (Arrays.equals(source, target)) {
                res.add(i - lenp + 1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode438 leetCode438 = new LeetCode438();
        String s = "cbaebabacd", p = "abc";
        System.out.println(leetCode438.findAnagrams(s, p));
    }

}
