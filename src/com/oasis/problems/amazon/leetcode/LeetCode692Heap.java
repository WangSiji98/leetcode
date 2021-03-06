package com.oasis.problems.amazon.leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class LeetCode692Heap {
    public List<String> topKFrequent(String[] words, int k) {
        int n = words.length;

        Map<String, Integer> freqMap = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            freqMap.put(words[i], freqMap.getOrDefault(words[i], 0) + 1);
        }

        // 先按照，频率大小排序
        // 如果频率相同，则按照key的字母顺序排序
        PriorityQueue<Map.Entry<String, Integer>> priorityQueue = new PriorityQueue<>(
            new Comparator<Map.Entry<String, Integer>>() {
                @Override
                public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                    return o1.getValue().equals(o2.getValue()) ? o1.getKey().compareTo(o2.getKey()) : o2.getValue() - o1.getValue();
                }
            }
        );

        for (Map.Entry<String, Integer> item: freqMap.entrySet()) {
            priorityQueue.offer(item);
        }
        List<String> res = new ArrayList<>();
        for (int i = 0; i < k; ++i) {
            res.add(priorityQueue.poll().getKey());
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode692Heap leetCode692Heap = new LeetCode692Heap();
        String[] words = new String[]{"i", "love", "leetcode", "i", "love", "coding"};
        int k = 2;
        System.out.println(leetCode692Heap.topKFrequent(words, k));
    }

}
