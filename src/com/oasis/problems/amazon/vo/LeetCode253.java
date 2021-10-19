package com.oasis.problems.amazon.vo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class LeetCode253 {
    public int minMeetingRooms(int[][] intervals) {
        int n = intervals.length;
        if (n == 0) {
            return 0;
        }

        // 最小堆
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            intervals.length,
            new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1 - o2;
                }
            }
        );

        Arrays.sort(
            intervals,
            new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[0] - o2[0];
                }
            }
        );
        // 最小堆中存放的是 结束时间
        pq.add(intervals[0][1]);
        for (int i = 1; i < n; ++i) {
            if (intervals[i][0] > pq.peek()) {
                pq.poll();
            }
            pq.offer(intervals[i][1]);
        }
        return pq.size();
    }

}
