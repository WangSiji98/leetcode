package com.oasis.problems.hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LeetCode56 {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][2];
        }
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

//        Arrays.sort(intervals, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] interval1, int[] interval2) {
//                return interval1[0] - interval2[0];
//            }
//        });
        int n = intervals.length;
        int left = intervals[0][0];
        int right = intervals[0][1];
        int i = 1;
        List<int[]> res = new ArrayList<>();
        while (i < n) {
            int[] interval = intervals[i];
            if (interval[0] > right) {
                res.add(new int[]{left, right});
                left = interval[0];
                right = interval[1];
            } else {
                right = Math.max(interval[1], right);
            }
            ++i;
        }
        res.add(new int[]{left, right});
        return res.toArray(new int[res.size()][]);
    }

    public static void main(String[] args) {
        LeetCode56 leetCode56 = new LeetCode56();
        int[][] intervals = new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] res = leetCode56.merge(intervals);
        int n = res.length;
        for (int i = 0; i < n; i++) {
            System.out.print(res[i][0]);
            System.out.print(res[i][1]);
        }
    }
}
