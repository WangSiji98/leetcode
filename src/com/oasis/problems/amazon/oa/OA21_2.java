package com.oasis.problems.amazon.oa;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Two sum unique pairs. 类似LC1，只不过让把一个给定的input数组nums里面全部的相加为的unique pair都找出来。两对数互为unique pair指的是两组数中至少有1个数不一样，比如[5, 7]和[7, 5]不会被认定为两对unique pair。
 */

public class OA21_2 {

   public int uniquePair(int[] nums, int target) {
       Set<Integer> set = new HashSet<>();
       for (int i: nums) {
           set.add(i);
       }
       int res = 0;
       for (int i: set) {
           if (set.contains(target - i)) {
               ++res;
           }
       }
       return res / 2;
   }

   public static void main(String[] args) {
       OA21_2 oa21_2 = new OA21_2();
       int[] nums = new int[]{1, 6, 2, 5, 3, 2};
       System.out.println(oa21_2.uniquePair(nums, 7));
   }

}
