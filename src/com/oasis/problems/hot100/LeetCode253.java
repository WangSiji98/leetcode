package com.oasis.problems.hot100;

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
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(
            intervals.length,
            new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1 - o2;
                }
            }
        );

        // 对会议室的开始时间排序 升序
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
        minHeap.add(intervals[0][1]);

        for (int i = 1; i < n; ++i) {
            if (intervals[i][0] >= minHeap.peek()) {
                minHeap.remove();
            }
            minHeap.add(intervals[i][1]);
        }
        return minHeap.size();
    }

    public static void main(String[] args) {
        LeetCode253 leetCode253 = new LeetCode253();
        int[][] intervals = new int[][]{{13, 15}, {1, 10}, {15, 20}};
        System.out.println(leetCode253.minMeetingRooms(intervals));
    }

}
