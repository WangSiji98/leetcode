package com.oasis.problems.amazon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

// 有返回顺序要求，需要按照频率从到到低排序，这时候不能使用quickselect
// 如果只是为了找出前K的元素，且无顺序要求，快速选择是最优解法
public class LeetCode692 {
    private Random rand = new Random();

    class Pair {
        String word;
        int freq;
        Pair(String word, int freq) {
            this.word = word;
            this.freq = freq;
        }
    }

    public List<String> topKFrequent(String[] words, int k) {
        int n = words.length;
        Map<String, Integer> freqMap = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            freqMap.put(words[i], freqMap.getOrDefault(words[i], 0) + 1);
        }
        List<Pair> freqList = new ArrayList<>();
        for (Map.Entry<String, Integer> item: freqMap.entrySet()) {
            freqList.add(new Pair(item.getKey(), item.getValue()));
        }
        quickSelect(freqList, 0, freqList.size() - 1, k);
        List<String> res = new ArrayList<>();
        for (int i = 0; i < k; ++i) {
            res.add(freqList.get(i).word);
        }
        Collections.sort(res);
        return res;
    }

    private void quickSelect(List<Pair> freqList, int l, int r, int k) {
        int randK = randomPartition(freqList, l, r);
        if (randK == k - 1) {
            return;
        }
        if (randK > k - 1) {
            quickSelect(freqList, l, randK - 1, k);
        } else {
            quickSelect(freqList, randK + 1, r, k);
        }
    }

    private int randomPartition(List<Pair> freqList, int l, int r) {
        int randIndex = l + rand.nextInt(r - l + 1);
        Collections.swap(freqList, randIndex, r);
        return partition(freqList, l, r);
    }

    private int partition(List<Pair> freqList, int l, int r) {
        int baseFreq = freqList.get(r).freq;
        int j = l - 1;
        for (int i = l; i < r; ++i) {
            if (freqList.get(i).freq > baseFreq) {
                Collections.swap(freqList, i, ++j);
            }
        }
        Collections.swap(freqList, r, ++j);
        return j;
    }

    public static void main(String[] args) {
        LeetCode692 leetCode692 = new LeetCode692();
        String[] words = new String[]{"i", "love", "leetcode", "i", "love", "coding"};
        int k = 2;
        System.out.println(leetCode692.topKFrequent(words, k));
    }

}
