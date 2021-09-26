package com.oasis.problems.hot100;

import java.util.Stack;

public class LeetCode394 {
    private int index;
    private Stack<String> stk = null;

    public String decodeString(String s) {
        this.stk = new Stack<>();
        this.index = 0;
        while (this.index < s.length()) {
            char ch = s.charAt(this.index);
            if (Character.isDigit(ch)) {
                this.stk.add(this.getNumber(s));
                continue;
            }
            if (Character.isLetter(ch) || ch == '[') {
                this.stk.add(String.valueOf(ch));
                ++this.index;
                continue;
            }
            if (ch == ']') {
                String str = this.getString();
                String num = this.stk.pop();
                StringBuffer newStr = new StringBuffer();
                for (int i = 0; i < Integer.parseInt(num); ++i) {
                    newStr.append(str);
                }
                this.stk.add(newStr.toString());
                ++this.index;
            }
        }
        return this.getResult();
    }

    private String getNumber(String s) {
        StringBuffer num = new StringBuffer();
        while (Character.isDigit(s.charAt(this.index))) {
            num.append(s.charAt(this.index));
            ++this.index;
        }
        return num.toString();
    }

    private String getString() {
        String ans = "";
        while (!"[".equals(this.stk.peek())) {
            ans = this.stk.pop() + ans;
        }
        this.stk.pop();
        return ans;
    }
    private String getResult() {
        String res = "";
        while (!this.stk.isEmpty()) {
            String tmp = this.stk.pop();
            res = tmp + res;
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode394 leetCode394 = new LeetCode394();
        String s = "3[a]2[bc]";
        System.out.println(leetCode394.decodeString(s));
    }
}
