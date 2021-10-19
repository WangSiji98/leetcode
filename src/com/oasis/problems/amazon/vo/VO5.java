package com.oasis.problems.amazon.vo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * interval sum，给一个arr，一个size k，让output出每一个interval size为k的sum的一个list，arr= [1,2,3,2,5],k=3, output=[6,7,10]
 */

public class VO5 {

    public List<Integer> intervalSum(int[] arr, int k) {
        int n = arr.length;
        Set<Integer> set = new HashSet<>();
        int left = 0;
        int right = 0;
        if (n < k) {
            return Collections.emptyList();
        }
        int ans = 0;
        for (int i = 0; i < k; ++i) {
            ans += arr[right];
            ++right;
        }
        set.add(ans);
        while (right < n - 1) {
            ans -= arr[left];
            ++left;
            ++right;
            ans += arr[right];
            set.add(ans);
        }
        return new ArrayList<>(set);
    }

    public static void main(String[] args) {
        VO5 vo5 = new VO5();
    }

}
