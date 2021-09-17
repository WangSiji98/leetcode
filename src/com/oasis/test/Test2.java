package com.oasis.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test2 {
    public static void main(String[] args) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        map.put(1, new ArrayList<>());
        List<Integer> list = map.get(1);
        list.add(2);
        System.out.println(map.get(1));
    }

}
