package com.oasis.problems.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LeetCode179 {
    public String largestNumber(int[] nums) {
        List<Integer> list = new ArrayList<Integer>(){{
            for (int i: nums) {
                add(i);
            }
        }};

        Collections.sort(
            list,
            new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    String s1 = String.valueOf(o1);
                    String s2 = String.valueOf(o2);
                    if (Long.parseLong(s1 + s2) > Long.parseLong(s2 + s1)) {
                        return -1;
                    } else if (Long.parseLong(s1 + s2) == Long.parseLong(s2 + s1)) {
                        return 0;
                    } else {
                        return 1;
                    }
                }
            }
        );
        StringBuilder stringBuilder = new StringBuilder();
        for (Integer i: list) {
            stringBuilder.append(i);
        }
        String res = stringBuilder.toString();
        int i = 0;
        while (i < res.length()) {
            if (res.charAt(i) == '0') {
                ++i;
            } else {
                break;
            }
        }
        res = res.substring(i, res.length());
        return "".equals(res) ? "0" : res;
    }

    public static void main(String[] args) {
        LeetCode179 leetCode179 = new LeetCode179();
        int[] nums = new int[]{0};
        System.out.println(leetCode179.largestNumber(nums));
    }

}
