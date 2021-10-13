package com.oasis.problems.alibaba;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import jdk.nashorn.internal.runtime.ListAdapter;

class Solution57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        int i = 0;
        List<int[]> list = new ArrayList<>();
        if (n == 0) {
            return new int[][]{newInterval};
        }

        while (i < n && newInterval[0] > intervals[i][1]) {
            ++i;
        }

        if (i == n) {
            list = new ArrayList<>(Arrays.asList(intervals));
            list.add(newInterval);
            return list.toArray(new int[n + 1][]);
        }
        for (int k = 0; k < i; ++k) {
            list.add(intervals[k]);
        }
        if (newInterval[1] < intervals[i][0]) {
            list.add(newInterval);
        } else {
            int left = Math.min(newInterval[0], intervals[i][0]);
            int right = Math.max(newInterval[1], intervals[i][1]);
            ++i;
            while (i < n) {
                if (intervals[i][0] > right) {
                    break;
                } else {
                    right = Math.max(right, intervals[i][1]);
                    ++i;
                }
            }
            list.add(new int[]{left, right});
        }
        while (i < n) {
            list.add(intervals[i]);
            ++i;
        }
        return list.toArray(new int[list.size()][]);
    }
}

public class LeetCode57 {

    public static void main(String[] args) {
        Solution57 solution57 = new Solution57();
//        int[][] intervals = new int[][]{
//            {1, 2},
//            {3, 5},
//            {6, 7},
//            {8, 10},
//            {12, 16}
//        };
        int[][] intervals = new int[][]{
            {1, 5},
        };

        int[] newIntervals = new int[]{0, 0};
        int[][] insert = solution57.insert(intervals, newIntervals);
        for (int[] array: insert) {
            System.out.println(Arrays.toString(array));
        }

    }

}
