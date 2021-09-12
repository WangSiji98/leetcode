package com.oasis.problems.amazon;

public class LeetCode43 {
    public String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        int m = num1.length(), n = num2.length();
        int[] ans = new int[m + n];

        for (int i = m - 1; i >= 0; i--) {
            int n1 = num1.charAt(i) - '0';
            for(int j = n - 1; j >= 0; j--) {
                int n2 = num2.charAt(j) - '0';
                ans[i + j + 1] += n1 * n2;
            }
        }
        for (int i = m + n - 1; i > 0; --i) {
            if (ans[i] >= 10) {
                ans[i - 1] += ans[i] / 10;
                ans[i] %= 10;
            }
        }

        int first = ans[0] == 0 ? 1: 0;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = first; i < m + n; i++) {
            stringBuilder.append(ans[i]);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        LeetCode43 leetCode43 = new LeetCode43();
        String num1 = "5";
        String num2 = "12";
        System.out.println(leetCode43.multiply(num1, num2));
    }
}
