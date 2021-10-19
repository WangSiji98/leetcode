package com.oasis.problems.amazon.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode763 {
    private Map<Character, Integer> map = new HashMap<>();

    public List<Integer> partitionLabels(String s) {
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            char ch = s.charAt(i);
            map.put(ch, i);
        }
        int cur = 0;
        List<Integer> res = new ArrayList<>();
        while (cur < n) {
            int start = cur;
            int right = cur;
            while (cur <= right) {
                right = Math.max(right, map.get(s.charAt(cur)));
                ++cur;
            }
            res.add(cur - start);
            System.out.println(s.substring(start, cur));
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "ababcbacadefegdehijhklij";
        LeetCode763 leetCode763 = new LeetCode763();
        System.out.println(leetCode763.partitionLabels(s));
    }
}
