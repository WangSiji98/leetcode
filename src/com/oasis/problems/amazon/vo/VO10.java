package com.oasis.problems.amazon.vo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VO10 {

    private Map<Integer, Integer> map = new HashMap<>();

    public List<Integer> fiterFrq(int[] nums, int start, int end) {
        for (int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Integer> res = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if (entry.getValue() >= start && entry.getValue() <= end) {
                res.add(entry.getKey());
            }
        }
        return res;
    }

}
