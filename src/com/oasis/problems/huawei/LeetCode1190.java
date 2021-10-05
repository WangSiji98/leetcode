package com.oasis.problems.huawei;

import java.util.List;
import java.util.Stack;

public class LeetCode1190 {
    private Stack<String> stk = new Stack<>();

    public String reverseParentheses(String s) {
        int n = s.length();
        int i = 0;
        while (i < n) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stk.add("(");
            } else if (Character.isLetter(ch)) {
                stk.add(String.valueOf(ch));
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                while (!"(".equals(stk.peek())) {
                    stringBuilder.append(new StringBuffer(stk.pop()).reverse().toString());
                }
                stk.pop();
                stk.add(stringBuilder.toString());
            }
            ++i;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (String tmp: stk) {
            stringBuilder.append(tmp);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        LeetCode1190 leetCode1190 = new LeetCode1190();
        String s = "a(bcdefghijkl(mno)p)q";
        System.out.println(leetCode1190.reverseParentheses(s));
    }

}
