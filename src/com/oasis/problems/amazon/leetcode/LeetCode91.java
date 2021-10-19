package com.oasis.problems.amazon.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LeetCode91 {
    private static Map<Integer, String> map;

    Set<String> res = new HashSet<>();
    StringBuffer ans = new StringBuffer();

    // 算法的思考优先级是 贪心 > dp > dfs/bfs 因为搜索算法就是暴力
    public int numDecodings1(String s) {
        map = new HashMap<Integer, String>();
        for (int i = 0; i < 26; ++i) {
            map.put(i + 1, String.valueOf((char)('A' + i)));
        }
        backtrack(s, 0);
        return res.size();
    }

    private void backtrack(String s, int index) {
        if (index == s.length() && ans.length() != 0) {
            res.add(ans.toString());
            return;
        }
        if (s.charAt(index) == '0') {
            return;
        }
        ans.append(map.get(Integer.parseInt(String.valueOf(s.charAt(index)))));
        backtrack(s, index + 1);
        ans.deleteCharAt(ans.length() - 1);
        if (index + 1 < s.length()) {
            int i = Integer.parseInt(String.valueOf(s.charAt(index)) + String.valueOf(s.charAt(index + 1)));
            if (i > 26) {
                return;
            }
            ans.append(map.get(i));
            backtrack(s, index + 2);
            ans.deleteCharAt(ans.length() - 1);
        }
    }

    // dp解法
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; ++i) {
            if (s.charAt(i - 1) != '0') {
                dp[i] += dp[i - 1];
            }
            if (i > 1) {
                if (s.charAt(i - 2) != '0' && Integer.parseInt(s.substring(i - 2, i)) <= 26) {
                    dp[i] += dp[i - 2];
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        LeetCode91 leetCode91 = new LeetCode91();
        String s = "12";
        System.out.println(leetCode91.numDecodings(s));
    }

}
