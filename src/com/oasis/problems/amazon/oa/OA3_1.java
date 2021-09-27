package com.oasis.problems.amazon.oa;

import java.util.HashMap;
import java.util.Map;

/**
 * LC387
 *
 * Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.
 *
 * Example 1:
 *
 * Input: s = "leetcode"
 * Output: 0
 * Example 2:
 *
 * Input: s = "loveleetcode"
 * Output: 2
 * Example 3:
 *
 * Input: s = "aabb"
 * Output: -1
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 105
 * s consists of only lowercase English letters.
 */

public class OA3_1 {
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
        OA3_1 oa3_1 = new OA3_1();
        String s = "loveleetcode";
        System.out.println(oa3_1.firstUniqChar(s));
    }

}
