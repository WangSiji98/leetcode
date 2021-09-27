package com.oasis.problems.amazon.oa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * LC56
 *
 * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.
 *
 *
 *
 * Example 1:
 *
 * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 * Example 2:
 *
 * Input: intervals = [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 *
 *
 * Constraints:
 *
 * 1 <= intervals.length <= 104
 * intervals[i].length == 2
 * 0 <= starti <= endi <= 104
 */

public class OA4_1 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(
            intervals,
            new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[0] - o2[0];
                }
            }
        );
        int n = intervals.length;
        int left = intervals[0][0];
        int right = intervals[0][1];
        int i = 1;
        List<int[]> list = new ArrayList<>();
        while (i < n) {
            int[] curr = intervals[i];
            if (curr[0] > right) {
                list.add(new int[]{left, right});
                left = curr[0];
                right = curr[1];
            } else {
                right = Math.max(right, curr[1]);
            }
            ++i;
        }
        list.add(new int[]{left, right});
        return list.toArray(new int[list.size()][]);
    }

    public static void main(String[] args) {
        OA4_1 oa4_1 = new OA4_1();
        int[][] intervals = new int[][]{
            {1, 3},
            {2, 6},
            {4, 5},
            {8, 10},
            {10, 13},
            {11, 15}
        };
        int[][] res = oa4_1.merge(intervals);
        for (int[] i: res) {
            System.out.println(Arrays.toString(i));
        }
    }

}
