package com.oasis.problems.amazon.leetcode;

public class LeetCode67 {
    public String addBinary(String a, String b) {
        int m = a.length(), n = b.length();
        StringBuilder stringBuilder = new StringBuilder();
        int i = m - 1, j = n - 1;
        int carry = 0;
        int ans = 0;
        while (i >= 0 || j >= 0) {
            ans = carry;
            ans += i >= 0 ? a.charAt(i) - '0' : 0;
            ans += j >= 0 ? b.charAt(j) - '0' : 0;
            stringBuilder.append(ans % 2);
            carry = ans / 2;
            --i;
            --j;
        }
        stringBuilder.append(carry == 0 ? "" : carry);
        return stringBuilder.reverse().toString();
    }

    public static void main(String[] args) {
        LeetCode67 leetCode67 = new LeetCode67();
        String a = "111";
        String b = "1";
        System.out.println(leetCode67.addBinary(a, b));
    }

}
