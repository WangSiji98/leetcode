package com.oasis.problems.amazon.vo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

class TimeMapSuper {

    private HashMap<String, TreeMap<Integer, String>> map;

    public TimeMapSuper() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k-> new TreeMap<>()).put(timestamp, value);
    }

    public String get(String key, int timestamp) {
        if(!map.containsKey(key)) {
            return "";
        }
        Integer time = map.get(key).floorKey(timestamp);
        if(time == null) {
            return "";
        }
        return map.get(key).get(time);
    }
}

class MyTimeMap {

    private class Item{
        int timestamp;
        String value;
        public Item(){}
        public Item(int _timestamp, String _value) {
            timestamp = _timestamp;
            value = _value;
        }
    }

    private Map<String, List<Item>> map;

    public MyTimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new ArrayList<>()).add(new Item(timestamp, value));
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }
        List<Item> list = map.get(key);
        return binarySearch(list, timestamp);
    }

    public String binarySearch(List<Item> list, int timestamp) {
        int n = list.size();
        int l = 0, r = n - 1;
        while (l < r) {
            int mid = (l + r + 1) >> 1;
            // mid 依然有可能是 我们要找的数
            if (list.get(mid).timestamp <= timestamp) {
                l = mid;
            } else {
                // l最终的结果就是第一个小于等于target的数字
                r = mid - 1;
            }
        }
        return r == timestamp ? list.get(r).value : "";
    }
}

public class LC981 {
    public static void main(String[] args) {
    }

}
