package com.oasis.problems.amazon.oa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.Set;
import javax.swing.JList;

/**
 * lc 973 mid
 *
 * https://leetcode.com/problems/k-closest-points-to-origin/
 */

class QuickSelect {
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
        if (left > right) {
            return;
        }
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
}

class Heap {
    private PriorityQueue<int[]> pq = new PriorityQueue<int[]>(
        new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return getDistance(o2) - getDistance(o1);
            }
        }
    );

    private int getDistance(int[] o) {
        return o[0] * o[0] + o[1] * o[1];
    }

    public int[][] kClosest(int[][] points, int k) {
        for (int[] point: points) {
            pq.offer(point);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        List<int[]> res = new ArrayList<>();
        for (int[] point: pq) {
            res.add(point);
        }
        return res.toArray(new int[res.size()][]);
    }
}

public class OA10_2 {

    public static void main(String[] args) {
        Heap heap = new Heap();
        int[][] points = new int[][]{
            {1, 2},
            {1, -1},
            {3, 4},
            {0, 1},
            {1, 0}
        };
        int[][] res = heap.kClosest(points, 2);
        for (int[] i: res) {
            System.out.println(Arrays.toString(i));
        }
    }


}
