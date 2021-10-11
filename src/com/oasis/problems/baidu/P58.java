package com.oasis.problems.baidu;

public class P58 {

    // 判断是否回文，直接翻转字符串
    public static boolean isHuiwen(String s) {
        return s.equals(new StringBuffer(s).reverse().toString());
    }

    public static boolean isHuiwen2(String s) {
        int n = s.length();
        int i = 0, j = n - 1;
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "12321";
        System.out.println(isHuiwen2(s));
    }

}
