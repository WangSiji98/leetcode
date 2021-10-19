package com.oasis.problems.amazon.vo;

import java.util.Stack;

public class LC227 {
    private Stack<Integer> stk = new Stack<>();

    public int calculate(String s) {
        int n = s.length();
        char curSign = '+';
        int i = 0;
        while (i < n) {
            char ch = s.charAt(i);
            if (ch == ' ') {
                ++i;
                continue;
            }
            if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                curSign = ch;
                ++i;
            } else if (Character.isDigit(ch)) {
                int j = i;
                int ans = 0;
                while (i < n && Character.isDigit(s.charAt(i))) {
                    ans = ans * 10 + (s.charAt(i) - '0');
                    ++i;
                }
                if (curSign == '+') {
                    stk.add(ans);
                } else if (curSign == '-') {
                    stk.add(-(ans));
                } else if (curSign == '*') {
                    int top = stk.pop();
                    stk.add(top * ans);
                } else {
                    int top = stk.pop();
                    stk.add(top / ans);
                }
            }
        }
        // 最后只需要处理加法就行
        int res = 0;
        while (!stk.isEmpty()) {
            res += stk.pop();
        }
        return res;
    }

}
