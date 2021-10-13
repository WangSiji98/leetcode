package com.oasis.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListArrayTest {
    public static void main(String[] args) {
        List<int[]> list = null;
        int[][] intervals = new int[][]{
            {1, 2},
            {3, 4},
            {5, 6}
        };
        int[] newInterval = new int[]{7 , 8};
        int n = 3;

        list = new ArrayList<>(Arrays.asList(intervals));
        list.add(newInterval);
        int[][] ints = list.toArray(new int[n + 1][]);
        for (int[] item: ints) {
            System.out.println(Arrays.toString(item));
        }
    }

}
