package com.oasis.problems.amazon.leetcode;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class LeetCode973D {
    private int[] dis;

    public int[][] kClosest(int[][] points, int k) {
        int n = points.length;
        dis = new int[n];
        for (int i = 0; i < n; ++i) {
            dis[i] = points[i][0] * points[i][0] + points[i][1] * points[i][1];
        }
        quickSelect(dis, 0, dis.length - 1, k);
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < k; ++i) {
            set.add(dis[i]);
        }
        int[][] res = new int[k][2];
        int j = 0;
        for (int i = 0; i < n; ++i) {
            if (set.contains(points[i][0] * points[i][0] + points[i][1] * points[i][1] )) {
                if (j >= k) {
                    break;
                }
                res[j] = points[i];
                ++j;
            }
        }
        return res;
    }

    private void quickSelect(int[] nums, int left, int right, int k) {
        int randK = partition(nums, left, right);
        if (randK == k - 1) {
            return;
        }
        if (randK > k - 1) {
            quickSelect(nums, left, randK - 1, k);
        } else {
            quickSelect(nums, randK + 1, right, k);
        }
    }

    private int randomPartion(int[] nums, int left, int right) {
        Random random = new Random();
        int randomNum = left + random.nextInt(right - left + 1);
        swap(nums, right, randomNum);
        return partition(nums, left, right);
    }

    private int partition(int[] nums, int left, int right) {
        int base = right;
        int j = left - 1;
        for (int i = left; i < right; ++i) {
            if (dis[i] < dis[base]) {
                swap(nums, i, ++j);
            }
        }
        swap(nums, base, ++j);
        return j;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        LeetCode973D leetCode973D = new LeetCode973D();
        int[][] points = new int[][]{{1, 3}, {-2, 2}, {2, -2}};
        int k = 2;
        int[][] res = leetCode973D.kClosest(points, k);
        for (int i = 0; i < res.length; ++i) {
            for (int j = 0; j < res[0].length; ++j) {
                System.out.print(res[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
