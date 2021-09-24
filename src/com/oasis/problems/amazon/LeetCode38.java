package com.oasis.problems.amazon;

import java.util.HashMap;
import java.util.Map;

public class LeetCode38 {
    private Map<Integer, String> ans = new HashMap<Integer, String>(){{
        put(1, "1");
        put(2, "11");
    }};
    private int max = 2;

    public String countAndSay(int n) {
        if (ans.containsKey(n)) {
            return ans.get(n);
        }
        for (int i = max + 1; i <= n; ++i) {
            String last = ans.get(i - 1);
            int count = 0;
            char cur = ' ';
            StringBuilder stringBuilder = new StringBuilder();
            for (int k = 0; k < last.length(); ++k) {
                if (cur != last.charAt(k)) {
                    if (count != 0) {
                        stringBuilder.append(count);
                        stringBuilder.append(cur);
                    }
                    cur = last.charAt(k);
                    count = 1;
                } else {
                    ++count;
                }
            }
            stringBuilder.append(count);
            stringBuilder.append(cur);
            ans.put(i, stringBuilder.toString());
        }
        max = Math.max(max, n);
        return ans.get(n);
    }

    public static void main(String[] args) {
        LeetCode38 leetCode38 = new LeetCode38();
        System.out.println(leetCode38.countAndSay(5));
    }
}
