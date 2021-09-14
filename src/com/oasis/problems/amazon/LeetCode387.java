package com.oasis.problems.amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class LeetCode387 {
    private Map<Character, Integer> map = new HashMap<>();

    public int firstUniqChar(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); ++i) {
            char ch = chars[i];
            if (map.containsKey(ch)) {
                map.put(ch, -1);
            } else {
                map.put(ch, i);
            }
        }
        for (int i = 0; i < s.length(); ++i) {
            if (map.get(chars[i]) != -1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        LeetCode387 leetCode387 = new LeetCode387();
        String s = "loveleetcode";
        System.out.println(leetCode387.firstUniqChar(s));
    }

}
