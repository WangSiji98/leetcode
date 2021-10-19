package com.oasis.problems.amazon.vo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class LC347 {
    Random random = new Random();

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> feqMap = new HashMap<>();
        for (int num: nums) {
            feqMap.put(num, feqMap.getOrDefault(num, 0) + 1);
        }
        List<int[]> freqList = new ArrayList<>();
        for (Map.Entry<Integer, Integer> item: feqMap.entrySet()) {
            freqList.add(new int[]{item.getKey(), item.getValue()});
        }
        int index = quickSelect(freqList, 0, freqList.size() - 1, k);
        int[] res = new int[k];
        for (int i = 0; i < k; ++i) {
            res[k - i - 1] = freqList.get(index + i)[0];
        }
        return res;
    }

    private int quickSelect(List<int[]> list, int left, int right, int k) {
        int randK = randomPartition(list, left, right);
        if (randK == right - k + 1) {
            return randK;
        }
        return randK > k ? quickSelect(list, left, randK - 1, k) : quickSelect(list, randK + 1, right, k);
    }

    private int randomPartition(List<int[]> list, int left, int right) {
        random = new Random();
        int rand = left + random.nextInt(right - left + 1);
        Collections.swap(list, left, rand);
        return partition(list, left, right);
    }

    private int partition(List<int[]> list, int left, int right) {
        int[] base = list.get(left);
        int j = right + 1;
        for (int i = left; i <= right; ++i) {
            if (list.get(i)[1] > base[1]) {
                Collections.swap(list, --j, i);
            }
        }
        Collections.swap(list, left, --j);
        return j;
    }

}
