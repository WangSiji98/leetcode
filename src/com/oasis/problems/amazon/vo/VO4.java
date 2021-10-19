package com.oasis.problems.amazon.vo;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 给一个括号序列，含大中小三种括号，判断序列是否合法，用栈即可。follow up是各种特殊情况（如输入为空，非字符串等等）
 */

public class VO4 {
    private String s;

    private static Map<Character, Character> map = new HashMap<Character, Character>(){{
        put(')', '(');
        put(']', '[');
        put('}', '{');
    }};

    public boolean isLegal(String _s) {
        s = _s;
        int n = s.length();
        if (n == 0) {
            return true;
        }
        if (!isInputLegal()) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        n = s.length();
        for (int i = 0; i < n; ++i) {
            char ch = s.charAt(i);
            if (stack.isEmpty() || ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else {
                if (stack.peek().equals(map.get(ch))) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    // follow up 处理非法输入
    private boolean isInputLegal() {
        int n = s.length();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < n; ++i) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == ')' || ch == '[' || ch == ']' || ch == '{' || ch == '}') {
                stringBuilder.append(ch);
            } else if (ch == ' ') {
                continue;
            } else {
                return false;
            }
        }
        s = stringBuilder.toString();
        return true;
    }

    public static void main(String[] args) {
        VO4 vo4 = new VO4();
        String s = " (()){}[]";
        System.out.println(vo4.isLegal(s));
    }

}
