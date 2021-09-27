package com.oasis.problems.amazon.oa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a List<String>, remove all occurrences of anagrams, keep the original. Return the sorted List<String>.
 *
 * https://evelynn.gitbooks.io/amazon-interview/content/string/find-all-anagrams-in-a-string.html
 */

class Solution11_1 {
    private final Map<String, String> map = new HashMap<>();

    public List<String> anagrams(List<String> strings) {
        for (String s: strings) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String sorted = String.valueOf(chars);
            if (!map.containsKey(sorted)) {
                map.put(sorted, s);
            }
        }
        ArrayList<String> res = new ArrayList<>(map.values());
        Collections.sort(res);
        return res;
    }
}

public class OA11_1 {
    public static void main(String[] args) {
        Solution11_1 solution11_1 = new Solution11_1();
        List<String> strings = new ArrayList<String>(){{
           add("fed");
           add("abc");
           add("def");
           add("cba");
        }};
        System.out.println(solution11_1.anagrams(strings));
    }
}
