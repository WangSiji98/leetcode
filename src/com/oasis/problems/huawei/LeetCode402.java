package com.oasis.problems.huawei;

import java.util.Stack;

public class LeetCode402 {
    private Stack<Integer> stk = new Stack<>();

    public String removeKdigits(String num, int k) {
        for (int i = 0; i < num.length(); ++i) {
            int cur = Integer.parseInt(num.substring(i, i + 1));
            if (stk.isEmpty() || stk.peek() <= cur || k == 0) {
                stk.add(cur);
            } else {
                while (!stk.isEmpty() && stk.peek() > cur && k > 0) {
                    stk.pop();
                    --k;
                }
                stk.add(cur);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i: stk) {
            stringBuilder.append(i);
        }
        String res = stringBuilder.substring(0, stringBuilder.length() - Math.max(k, 0));
        if ("".equals(res)) {
            return "0";
        } else {
            int j = 0;
            while (j < res.length()) {
                if (res.charAt(j) != '0') {
                    break;
                }
                ++j;
            }
            res =  res.substring(j);
            if ("".equals(res)) {
                return "0";
            } else {
                return res;
            }
        }
    }

    public static void main(String[] args) {
        LeetCode402 leetCode402 = new LeetCode402();
        String num = "10";
        int k = 1;
        System.out.println(leetCode402.removeKdigits(num, k));
    }

}
