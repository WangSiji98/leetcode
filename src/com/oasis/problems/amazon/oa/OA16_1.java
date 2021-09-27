package com.oasis.problems.amazon.oa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Amazon Fresh Deliveries
 * Given allLocations list of co-ordinates (x,y) you have to find the X - closest locations from truck's location which is (0,0). Distance is calculated using formula (x^2 + y^2).
 * If the there is tie then choose the co-ordinate with least x value.
 * Sample Input :
 * allLocations : [ [1, 2] , [1, -1], [3, 4] ]
 * numOfDeliveries : 2
 * Sample Output :
 * [ [1, -1], [1 , 2] ]
 * Output list can be in any order.
 * This question was basically K closest points to the origin (0,0) with added tie condition.
 */

public class OA16_1 {

    public List<List<Integer>> delivery(int[][] locations, int numOfDeliveries) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            new Comparator<Integer>() {
                @Override
                public int compare(Integer i1, Integer i2) {
                    return getDistance(locations[i2]) - getDistance(locations[i1]);
                }
            }
        );

        for (int i = 0; i < locations.length; ++i) {
            pq.add(i);
            if (pq.size() > numOfDeliveries) {
                pq.poll();
            }
        }

        List<List<Integer>> res = new ArrayList<>();
        for (Integer i: pq) {
            res.add(new ArrayList<Integer>(){{
                add(locations[i][0]);
                add(locations[i][1]);
            }});
        }
        return res;
    }

    private int getDistance(int[] l1) {
        return l1[0] * l1[0] + l1[1] * l1[1];
    }

    public static void main(String[] args) {
        OA16_1 oa16_1 = new OA16_1();
        int[][] locations = new int[][]{
            {1, 2},
            {1, -1},
            {3, 4},
            {0, 1}
        };
        System.out.println(oa16_1.delivery(locations, 2));
    }

}
