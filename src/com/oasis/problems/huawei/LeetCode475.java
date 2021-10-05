package com.oasis.problems.huawei;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LeetCode475 {
    public int findRadius(int[] houses, int[] heaters) {
        List<Integer> radius = new ArrayList<>();
        for (int house: houses) {
            int min = Integer.MAX_VALUE;
            for (int heater: heaters) {
                min = Math.min(min, Math.abs(house - heater));
            }
            radius.add(min);
        }
        return Collections.max(radius);
    }

    public static void main(String[] args) {
        LeetCode475 leetCode475 = new LeetCode475();
        int[] houses = new int[]{1, 2, 3, 4};
        int[] heaters = new int[]{1, 4};
        System.out.println(leetCode475.findRadius(houses, heaters));
    }
}
