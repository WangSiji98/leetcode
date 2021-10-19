package com.oasis.problems.amazon.vo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeMap {

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

    public TimeMap() {
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
        return list.get(r).timestamp <= timestamp ? list.get(r).value : "";
    }

    public static void main(String[] args) {
        TimeMap timeMap = new TimeMap();
        timeMap.set("foo", "bar1", 2);
        timeMap.set("foo", "bar2", 3);
        timeMap.set("foo", "bar3", 4);
        System.out.println(timeMap.get("foo", 1));
    }
}