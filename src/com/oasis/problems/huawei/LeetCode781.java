package com.oasis.problems.huawei;

import java.util.HashMap;
import java.util.Map;

public class LeetCode781 {
    private Map<Integer, Integer> map = new HashMap<>();

    public int numRabbits(int[] answers) {
        for (int i: answers) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        int res = 0;
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            res += (int) Math.ceil(value / (key + 1.0)) * (key + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode781 leetCode781 = new LeetCode781();
        int[] answer = new int[]{1, 1, 2};
        System.out.println(leetCode781.numRabbits(answer));
    }
}
