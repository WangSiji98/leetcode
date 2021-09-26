package com.oasis.problems.hot100;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LeetCode139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        wordDict.sort(Comparator.comparingInt(String::length));
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        int[][] mem = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            dp[i] = false;
            for (int j = 0; j <= n; ++j) {
                mem[i][j] = -1;
            }
        }
        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (mem[j][i] == -1) {
                    mem[j][i] = wordDict.contains(s.substring(j, i)) ? 1 : 0;
                }
                if (dp[j] && mem[j][i] == 1) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        LeetCode139 leetCode139 = new LeetCode139();
        String s = "leetcode";
        List<String> wordDict = Arrays.asList("leet", "code");
        System.out.println(leetCode139.wordBreak(s, wordDict));
    }

}
