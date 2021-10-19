package com.oasis.problems.amazon.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class LeetCode322 {

    private Map<String, PriorityQueue<String>> map = new HashMap<>();
    private Deque<String> deque = new ArrayDeque<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        for (List<String> ticket: tickets) {
            String src = ticket.get(0), dst = ticket.get(1);
            if (!map.containsKey(src)) {
                map.put(src, new PriorityQueue<>());
            }
            map.get(src).offer(dst);
        }
        dfs("JFK");
        return new ArrayList<>(deque);
    }

    private void dfs(String cur) {
        while (map.containsKey(cur) && map.get(cur).size() > 0) {
            String next = map.get(cur).poll();
            dfs(next);
        }
        deque.addFirst(cur);
    }

    public static void main(String[] args) {
        LeetCode322 leetCode322 = new LeetCode322();
        List<List<String>> tickets = new ArrayList<List<String>>(){{
           add(Arrays.asList("JFK","SFO"));
           add(Arrays.asList("JFK","ATL"));
           add(Arrays.asList("SFO","ATL"));
           add(Arrays.asList("ATL","JFK"));
           add(Arrays.asList("ATL","SFO"));
        }};
        System.out.println(leetCode322.findItinerary(tickets));
    }

}
