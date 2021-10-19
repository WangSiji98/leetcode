package com.oasis.problems.amazon.vo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC17 {
    List<String> res = null;
    StringBuffer ans = null;

    public List<String> letterCombinations(String digits) {
        if ("".equals(digits)) {
            return Collections.emptyList();
        }

        Map<String, String> numsMap = new HashMap<String, String>() {{
            put("2", "abc");
            put("3", "def");
            put("4", "ghi");
            put("5", "jkl");
            put("6", "mno");
            put("7", "pqrs");
            put("8", "tuv");
            put("9", "wxyz");
        }};
        res = new ArrayList<>();
        ans = new StringBuffer();
        backTrack(numsMap, digits, 0);
        return res;
    }

    void backTrack(Map<String, String> numsMap, String digits, int index) {
        if (index == digits.length()) {
            res.add(ans.toString());
            return;
        }
        String curDight = digits.substring(index, index+1);
        String curAlphabits = numsMap.get(curDight);
        int n = curAlphabits.length();
        for (int i = 0; i < n; i++) {
            ans.append(curAlphabits.charAt(i));
            backTrack(numsMap, digits, index + 1);
            ans.deleteCharAt(index);
        }

    }

}
