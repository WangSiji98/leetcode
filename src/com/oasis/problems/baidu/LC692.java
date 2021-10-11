package com.oasis.problems.baidu;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

/**
 * 前面K个高频单词
 * 给一非空的单词列表，返回前 k 个出现次数最多的单词。
 *
 * 返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率，按字母顺序排序。
 */
public class LC692 {
    public List<String> topKFrequent(String[] words, int k) {
        int n = words.length;

        Map<String, Integer> freqMap = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            freqMap.put(words[i], freqMap.getOrDefault(words[i], 0) + 1);
        }

        // 先按照，频率大小排序
        // 如果频率相同，则按照key的字母顺序排序
        PriorityQueue<Entry<String, Integer>> priorityQueue = new PriorityQueue<>(
            new Comparator<Entry<String, Integer>>() {
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
        // Collections.reverse(res);
        return res;
    }
}
