package com.oasis.problems.hot100;

public class LeetCode5 {
    public String longestPalindrome(String s) {
        char[] charArray = s.toCharArray();
        int len = s.length();
        int ans = 1;
        int maxLfet = 0;
        int[][] dp = new int[len][len];
        for (int i = 0; i < len; ++i) {
            dp[i][i] = 1;
        }

        for (int l = 2; l <= len; ++l) {
            for (int i = 0; i < len; ++i) {
                int j = i + l - 1;
                if (j >= len) {
                    break;
                }
                if (charArray[i] == charArray[j]) {
                    if (l == 2) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                } else {
                    dp[i][j] = 0;
                }
                if (dp[i][j] == 1 && j - i + 1 > ans) {
                    ans = j - i + 1;
                    maxLfet = i;
                }
            }
        }
        return s.substring(maxLfet, maxLfet + ans);
    }

    public static void main(String[] args) {
        LeetCode5 leetCode5 = new LeetCode5();
        String s = "cbbd";
        System.out.println(leetCode5.longestPalindrome(s));
    }
}
