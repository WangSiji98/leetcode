package com.oasis.problems.amazon.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LeetCode378 {
    private static class Item{
        int num;
        int row;
        int index;

        Item(int _num, int _row, int _index) {
            num = _num;
            row = _row;
            index = _index;
        }
    }

    PriorityQueue<Item> pq = new PriorityQueue<>(
        new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                return o1.num - o2.num;
            }
        }
    );

    // 朴素的思路是多路归并
    public int kthSmallest(int[][] matrix, int k) {
        int cur = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; ++i) {
            pq.offer(new Item(matrix[i][0], i, 0));
        }
        for (int i = 0; i < k - 1; ++i) {
            Item item = pq.poll();
            if (item.index < n - 1) {
                item.num = matrix[item.row][item.index + 1];
                ++item.index;
                pq.offer(item);
            }
        }
        return pq.poll().num;
    }

    public static void main(String[] args) {
        LeetCode378 leetCode378 = new LeetCode378();
        int[][] matrix = new int[][]{
            {1, 5, 9},
            {10, 11, 13},
            {12, 13, 15}
        };
        int k = 8;
        System.out.println(leetCode378.kthSmallest(matrix, k));
    }
}
