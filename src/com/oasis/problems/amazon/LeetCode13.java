package com.oasis.problems.amazon;

import java.util.HashMap;
import java.util.Map;

public class LeetCode13 {
    static Map<Character, Integer> map = new HashMap<Character, Integer>(){{
        put('I', 1);
        put('V', 5);
        put('X', 10);
        put('L', 50);
        put('C', 100);
        put('D', 500);
        put('M', 1000);
    }};

    public int romanToInt(String s) {
        int n = s.length();
        if (n == 1) {
            return map.get(s.charAt(0));
        }
        int res = 0;
        for (int i = 0; i < n - 1; i++) {
            if (map.get(s.charAt(i + 1)) > map.get(s.charAt(i))) {
                res -= map.get(s.charAt(i));
            } else {
                res += map.get(s.charAt(i));
            }
        }
        res += map.get(s.charAt(n - 1));
        return res;
    }

    public static void main(String[] args) {
        LeetCode13 leetCode13 = new LeetCode13();
        System.out.println(leetCode13.romanToInt("D"));
    }

}
