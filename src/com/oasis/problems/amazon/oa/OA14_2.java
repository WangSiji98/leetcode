package com.oasis.problems.amazon.oa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/discuss/interview-question/1424367/Amazon-OA-or-Choose-a-flask
 * Choose a flask
 *
 *
 * What could be the best python solution for the following question? I came up with an approach that is O(n^3), but wanted to check if there is any better solution.
 * My approach : https://leetcode.com/playground/EoMQztiJ
 *
 * A robotic chemical delivery system for an Amazon laboratory has been configured to work using only one type of glass flask per day.
 * For each chemical ordered, it will be filled to a mark that is at least equal to the volume ordered.
 * There are multiple flasks available, each with markings at various levels. Given a list of order requirements and a list of flasks with their measurements, write an algorithm to determine the single type of flask that will result in minimal waste. Waste is the sum of marking - requirement for each order.
 * Output the zero-based index of the flask type chosen. If there are multiple answers, output the minimum index.
 * If no flask will satisfy the constraints, output -1.
 *
 * Input:
 * The input to the function/method consists of five arguments:
 * numOrders : an integer representing the number of orders;
 * requirements: a list of integers representing the requirements for the orders;
 * flaskTypes : an integer representing the number of flask types;
 * totalMarks : an integer representing the total number of markings;
 * markings: a list of pairs of integers where the first integer represents the index of the flask and second represents the one mark.
 * Output:
 * Return an integer representing the index of the flask to choose or return -1 if none will work.
 *
 * Constraints:
 * 1 <= numOrders <= 10^5
 * 1 <= flaskTypes <= 10^4
 * 1 <= totalMarks <= 10^5
 * 1 <= requirements[i] <= 10^9
 * 0 <= markings[i][0] < flaskTypes
 * 0 <= markings[i][1] <= 10^9
 * 0 <= j < numOrders .
 * 0 <= i < totalMarks
 *
 * Note:
 * The markings list will be given in order of the flasks, ie, the markings for the O-index flask will be followed by markings of the 1-index flask and so on.
 * For each flask, the given markings will also be sorted in ascending order.
 *
 * Examples:
 * Example 1:
 * Input: numOrders = 4 requirements = [4,6,6,7] flaskTypes = 3 totalMarks = 9 markings = [[0, 3], [0,5], [0,7],[1,6],[1,8], [1,9], [2,3], [2,5], [2,6]]
 *
 * Output: 0
 * Explanation:
 * The markings list is a list where the first element is the flask number and the second an available marking in this case, the first type has markings at 3, 5 and 7.
 * The second type has them at 6, 8 and 9, and the third type has markings at 3, 5 and 6. Using the first flask type, the losses are: 5 - 4 = 1, 7 -6 =1, 7 -6 = 1, 7- 7 = 0. 1 + 1 + 1 + 0 = 3 units wasted.
 * Using the second flask type, losses are: 6 - 4 = 2.6 - 6 = 0,6-6 = 0,8 - 7 = 1.2 + 0 + 0 + 1 = 3 units wasted.
 * The third flask type cannot be used because its maximum capacity is 6 and there is an order for 7.
 * Two types of flasks can be used and 3 units will be lost. The lower index flask is at index o.
 */

public class OA14_2 {
    private Map<Integer, List<Integer>> map = new HashMap<>();

    public int flask(int numOrders, int[] requirements, int flaskType, int totalMarks, int[][] markings) {
        for (int i = 0; i < totalMarks; ++i) {
            if (!map.containsKey(markings[i][0])) {
                map.put(markings[i][0], new ArrayList<>());
            }
            map.get(markings[i][0]).add(markings[i][1]);
        }
        int res = 0;
        int minWaste = Integer.MAX_VALUE;
        for (int i = 0; i < flaskType; ++i) {
            int waste = 0;
            boolean flag = true;
            for (int j = 0; j < numOrders; ++j) {
                int require = requirements[j];
                for (Integer mark: map.get(i)) {
                    if (mark > require) {
                        waste += mark - require;
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    break;
                }
            }
            if (waste < minWaste && flag) {
                minWaste = waste;
                res = i;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        OA14_2 oa14_2 = new OA14_2();
        int[] requirements = new int[]{4,6,6,7};
        int numOrders = 4;
        int flaskType = 3;
        int totalMarks = 9;
        int[][] markings = new int[][]{
            {0, 3},
            {0, 5},
            {0, 7},
            {1, 6},
            {1, 8},
            {1, 9},
            {2, 3},
            {2, 5},
            {2, 6},
        };
        System.out.println(oa14_2.flask(numOrders, requirements, flaskType, totalMarks,markings));
    }

}
