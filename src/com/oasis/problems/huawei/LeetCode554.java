package com.oasis.problems.huawei;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode554 {

    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> cnt = new HashMap<Integer, Integer>();
        for (List<Integer> widths : wall) {
            int n = widths.size();
            int sum = 0;
            for (int i = 0; i < n - 1; i++) {
                sum += widths.get(i);
                cnt.put(sum, cnt.getOrDefault(sum, 0) + 1);
            }
        }
        int maxCnt = 0;
        for (Map.Entry<Integer, Integer> entry : cnt.entrySet()) {
            maxCnt = Math.max(maxCnt, entry.getValue());
        }
        return wall.size() - maxCnt;
    }

    public static void main(String[] args) {
        LeetCode554 leetCode554 = new LeetCode554();
        List<List<Integer>> wall = new ArrayList<List<Integer>>(){{
            add(Arrays.asList(1, 2, 2, 1));
            add(Arrays.asList(3, 1, 2));
            add(Arrays.asList(1, 3, 2));
            add(Arrays.asList(2, 4));
            add(Arrays.asList(3, 1, 2));
            add(Arrays.asList(1, 3, 1, 1));
        }};
        System.out.println(leetCode554.leastBricks(wall));
    }
}
