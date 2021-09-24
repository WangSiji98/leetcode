package com.oasis.problems.competition;

import java.util.HashMap;
import java.util.Map;

public class Problem1_1 {
    private static Map<String, Integer> map = new HashMap<String, Integer>(){{
       put("X++", 1);
       put("++X", 1);
       put("X--", -1);
       put("--X", -1);
    }};

    public int finalValueAfterOperations(String[] operations) {
        int x = 0;
        for (String operation: operations) {
            x += map.get(operation);
        }
        return x;
    }

    public static void main(String[] args) {
        Problem1_1 problem1_1 = new Problem1_1();
        String[] operations = new String[]{"X++","++X","--X","X--"};
        System.out.println(problem1_1.finalValueAfterOperations(operations));
    }

}
