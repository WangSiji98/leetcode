package com.oasis.problems.amazon.vo;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class LC20 {
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

}
