package com.oasis.problems.amazon.oa;

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
    private int[] map;

    public int firstUniqChar(String s) {
        map = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            int index = s.charAt(i) - 'a';
            if (map[index] == 0) {
                map[index] = i + 1;
            } else if (map[index] != -1) {
                map[index] = -1;
            }
        }
        int min = 25;
        for (int i: map) {
            if (i != -1 && i != 0) {
                min = Math.min(min, i - 1);
            }
        }
        return min == 25 ? -1 : min;
    }

    public static void main(String[] args) {
        OA3_1 oa3_1 = new OA3_1();
        String s = "loveleetcode";
        System.out.println(oa3_1.firstUniqChar(s));
    }

}
