package com.oasis.problems.hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;


// 未完成
public class LeetCode347 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        List<int[]> freqList = new ArrayList<>();
        for (Map.Entry<Integer, Integer> item: freqMap.entrySet()) {
            freqList.add(new int[]{item.getKey(), item.getValue()});
        }
        int index = quickSelect(freqList, 0, freqList.size() - 1, k);
        int[] res = new int[k];
        for (int i = 0; i < k; ++i) {
            res[k - i - 1] = freqList.get(index + i)[0];
        }
        return res;
    }

    private int quickSelect(List<int[]> target, int left, int right, int k) {
        int randK = randomPartition(target, left, right);
        if (randK == k) {
            return right - k + 1;
        }
        return randK < k ? quickSelect(target, left, randK - 1, k) : quickSelect(target, randK + 1, right, k);
    }

    private int randomPartition(List<int[]> target, int left, int right) {
        Random random = new Random();
        int rand = left + random.nextInt(right - left + 1);
        Collections.swap(target, left, rand);
        return partition(target, left, right);
    }

    private int partition(List<int[]> target, int left, int right) {
        int[] base = target.get(left);
        int j = right + 1;
        for (int i = left; i <= right; ++i) {
            if (target.get(i)[1] > base[1]) {
                Collections.swap(target, --j, i);
            }
        }
        Collections.swap(target, left, --j);
        return right - j + 1;
    }

    public static void main(String[] args) {
        LeetCode347 leetCode347 = new LeetCode347();
        int[] nums = new int[]{1,1,1,2,2,3};
        int k = 2;
        System.out.println(Arrays.toString(leetCode347.topKFrequent(nums, k)));
    }

}
