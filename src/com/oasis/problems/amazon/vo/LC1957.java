package com.oasis.problems.amazon.vo;

public class LC1957 {
    public String makeFancyString(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        char curCh = '1';
        int curNum = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) != curCh) {
                curNum = 1;
                curCh = s.charAt(i);
                stringBuilder.append(curCh);
            } else {
                if (curNum < 2) {
                    stringBuilder.append(curCh);
                }
                ++curNum;
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        LC1957 lc1957 = new LC1957();
        String s = "leeetcode";
        System.out.println(lc1957.makeFancyString(s));
    }

}
