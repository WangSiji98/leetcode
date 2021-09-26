package com.oasis.problems.hot100;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class LeetCode76 {
//    private Set<String> set;
//    private Map<String, Integer> map;
//
//    public String minWindow(String s, String t) {
//        if (s.equals(t)) {
//            return s;
//        }
//        int sLen = s.length();
//        int tLen = t.length();
//        int min = Integer.MAX_VALUE;
//        int minLeft = -1;
//        int minRight = -1;
//
//        set = new HashSet<String>(Arrays.asList(t.split("")));
//        map = new HashMap<>();
//
//        int left = 0, right = 0;
//        while (left <= right && right <= sLen) {
//            if (map.keySet().size() == tLen) {
//                while (map.keySet().size() == tLen) {
//                    if (map.containsKey(String.valueOf(s.charAt(left)))) {
//                        Integer tmp = map.get(String.valueOf(s.charAt(left)));
//                        if (tmp == 1) {
//                            map.remove(String.valueOf(s.charAt(left)));
//                        } else {
//                            map.put(String.valueOf(s.charAt(left)), tmp - 1);
//                        }
//                    }
//                    ++left;
//                }
//                if (right - left + 1 <  min) {
//                    minLeft = left - 1;
//                    minRight = right;
//                    min = right - left + 1;
//                }
//            }
//            if (right < sLen && set.contains(String.valueOf(s.charAt(right)))) {
//                if (map.containsKey(String.valueOf(s.charAt(right)))) {
//                    map.put(String.valueOf(s.charAt(right)), map.get(String.valueOf(s.charAt(right))) + 1);
//                } else {
//                    map.put(String.valueOf(s.charAt(right)), 1);
//                }
//            }
//
//            ++right;
//        }
//        if (minLeft == -1 || minRight == -1) {
//            return "";
//        }
//        return s.substring(minLeft, minRight);
//    }

    Map<Character, Integer> ori = new HashMap<Character, Integer>();
    Map<Character, Integer> cnt = new HashMap<Character, Integer>();

    public String minWindow(String s, String t) {
        int tLen = t.length();
        for (int i = 0; i < tLen; i++) {
            char c = t.charAt(i);
            ori.put(c, ori.getOrDefault(c, 0) + 1);
        }
        int l = 0, r = -1;
        int len = Integer.MAX_VALUE, ansL = -1, ansR = -1;
        int sLen = s.length();
        while (r < sLen) {
            ++r;
            if (r < sLen && ori.containsKey(s.charAt(r))) {
                cnt.put(s.charAt(r), cnt.getOrDefault(s.charAt(r), 0) + 1);
            }
            while (check() && l <= r) {
                if (r - l + 1 < len) {
                    len = r - l + 1;
                    ansL = l;
                    ansR = l + len;
                }
                if (ori.containsKey(s.charAt(l))) {
                    cnt.put(s.charAt(l), cnt.getOrDefault(s.charAt(l), 0) - 1);
                }
                ++l;
            }
        }
        return ansL == -1 ? "" : s.substring(ansL, ansR);
    }

    public boolean check() {
        Iterator iter = ori.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            Character key = (Character) entry.getKey();
            Integer val = (Integer) entry.getValue();
            if (cnt.getOrDefault(key, 0) < val) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LeetCode76 leetCode76 = new LeetCode76();
        String s = "bbaa", t = "aba";
        System.out.println(leetCode76.minWindow(s, t));
    }
}
