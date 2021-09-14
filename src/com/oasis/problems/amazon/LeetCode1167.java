package com.oasis.problems.amazon;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LeetCode1167 {

    // 哈夫曼编码，这种问题，首先思考的是贪心，贪心不了再dp
    public int connectSticks(int[] sticks) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1 - o2;
                }
            }
        );
        for (int i = 0; i < sticks.length; ++i) {
            pq.offer(sticks[i]);
        }
        int cost = 0;
        while (pq.size() > 1) {
            int l1 = pq.poll();
            int l2 = pq.poll();
            cost += (l1 + l2);
            pq.offer(l1 + l2);
        }
        return cost;
    }

    public static void main(String[] args) {
        LeetCode1167 leetCode1167 = new LeetCode1167();
        int[] sticks = new int[]{2, 4, 3};
        System.out.println(leetCode1167.connectSticks(sticks));
    }

}
