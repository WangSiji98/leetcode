package com.oasis.problems.amazon;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LeetCode819 {
    public String mostCommonWord(String paragraph, String[] banned) {
//        String[] words = paragraph.split(" ");
//        Map<String, Integer> count = new HashMap<>();
//        Set<String> ban = new HashSet<>(Arrays.asList(banned));
//        String res = "";
//        int freq = -1;
//
//        for (String word: words) {
//            String tmp = word;
//            if (!Character.isLetter(word.charAt(word.length() - 1))) {
//                tmp = word.substring(0, word.length() - 1);
//            }
//            tmp = tmp.toLowerCase();
//            if (!ban.contains(tmp)) {
//                count.put(tmp, count.getOrDefault(tmp, 0) + 1);
//                if (count.get(tmp) > freq) {
//                    freq = count.get(tmp);
//                    res = tmp;
//                }
//            }
//        }
//        return res;

        // 我自己写的当出现"a,b,c,d"这种情况会无法处理
        // lc答案
        paragraph += ".";

        Set<String> banset = new HashSet();
        for (String word: banned) {
            banset.add(word);
        }
        Map<String, Integer> count = new HashMap();

        String ans = "";
        int ansfreq = 0;

        StringBuilder word = new StringBuilder();
        for (char c: paragraph.toCharArray()) {
            if (Character.isLetter(c)) {
                word.append(Character.toLowerCase(c));
            } else if (word.length() > 0) {
                String finalword = word.toString();
                if (!banset.contains(finalword)) {
                    count.put(finalword, count.getOrDefault(finalword, 0) + 1);
                    if (count.get(finalword) > ansfreq) {
                        ans = finalword;
                        ansfreq = count.get(finalword);
                    }
                }
                word = new StringBuilder();
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        LeetCode819 leetCode819 = new LeetCode819();
        String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String[] banned = new String[]{"hit"};
        System.out.println(leetCode819.mostCommonWord(paragraph, banned));
    }
}
