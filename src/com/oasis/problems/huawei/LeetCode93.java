package com.oasis.problems.huawei;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LeetCode93 {
    private List<String> res = new ArrayList<>();
    private List<Integer> cur = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        cur.add(0);
        backTrack(s, 0, 0);
        return res;
    }

    private void backTrack(String s, int index, int last) {
        if (index - last > 3) {
            return;
        }
        if (index == s.length() || cur.size() == 4) {
            String curStr = check(s);
            if (!"".equals(curStr)) {
                res.add(curStr);
            }
            return;
        }
        cur.add(index);
        backTrack(s, index + 1, index);
        cur.remove(cur.size() - 1);
        backTrack(s, index + 1, last);
    }

    private String check(String s) {
        if (cur.size() != 4) {
            return "";
        }
        cur.add(s.length());
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 4; ++i) {
            String tmpStr = s.substring(cur.get(i), cur.get(i + 1));
            if ("".equals(tmpStr) || tmpStr.length() > 3 || (tmpStr.length() > 1 && tmpStr.charAt(0) == '0')) {
                cur.remove(cur.size() - 1);
                return "";
            }
            int tmpInt = Integer.parseInt(tmpStr);
            if (tmpInt >= 0 && tmpInt < 256) {
                stringBuilder.append(tmpInt);
                if (i != 3) {
                    stringBuilder.append(".");
                }
            } else {
                cur.remove(cur.size() - 1);
                return "";
            }
        }
        cur.remove(cur.size() - 1);
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        LeetCode93 leetCode93 = new LeetCode93();
        String s = "25525511135";
        System.out.println(leetCode93.restoreIpAddresses(s));
    }
}
