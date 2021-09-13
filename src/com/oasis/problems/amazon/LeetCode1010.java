package com.oasis.problems.amazon;

import java.util.HashMap;
import java.util.Map;

public class LeetCode1010 {
    private Map<Integer, Integer> map = new HashMap<>();

    public int numPairsDivisibleBy60(int[] time) {
        int res = 0;
        for (int i = 0; i < time.length; ++i) {
            int cur = time[i] % 60;
            res += map.getOrDefault((60 - cur) % 60, 0);
            map.put(cur, map.getOrDefault(cur, 0) + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode1010 leetCode1010 = new LeetCode1010();
        int[] time = new int[]{30,20,150,100,40};
        System.out.println(leetCode1010.numPairsDivisibleBy60(time));
    }

}
