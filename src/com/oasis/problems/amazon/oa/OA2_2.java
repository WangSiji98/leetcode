package com.oasis.problems.amazon.oa;

import java.util.ArrayList;
import java.util.List;

/**
 * 给一个string，将string从每个valid的节点分成两个substring, prefix和suffix，求分出来的suffix和原字符串的prefix的总长度。例如“abab”，可产生的suffix有["abab"，"bab","ab","b"],common prefix则有[4,0,2,0],sum=6。
 */

public class OA2_2 {

    public int split(String s) {
        List<String> suffix = new ArrayList<>();
        for (int i = 0; i < s.length(); ++i) {
            suffix.add(s.substring(i, s.length()));
        }
        int res = 0;
        for (String pre: suffix) {
            if (checkPrefix(s, pre)) {
                res += pre.length();
            }
        }
        return res;
    }

    private boolean checkPrefix(String s, String pre) {
        int m = pre.length();
        int n = s.length();
        if (m > n) {
            return false;
        }
        for (int i = 0; i < m; ++i) {
            if (s.charAt(i) != pre.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        OA2_2 oa2_2 = new OA2_2();
        String s = "abab";
        System.out.println(oa2_2.split(s));
    }

}
