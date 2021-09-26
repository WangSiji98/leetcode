package com.oasis.problems.hot100;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class LeetCode20 {
    public boolean isValid(String s) {
        Stack<Character> stk = new Stack<>();
        Map<Character, Character> map = new HashMap<Character, Character>(){{
           put('{', '}');
           put('(', ')');
           put('[', ']');
        }};

        int n = s.length();
        for (int i =0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[') {
                stk.add(ch);
            }
            if (ch == ')' || ch == '}' || ch == ']') {
                if (stk.isEmpty()) {
                    return false;
                }
                Character pop = stk.pop();
                if (ch != map.get(pop)) {
                    return false;
                }
            }
        }
        return stk.isEmpty();
    }

    public static void main(String[] args) {
        LeetCode20 leetCode20 = new LeetCode20();
        String s = "()[]{}";
        System.out.println(leetCode20.isValid(s));
    }

}
