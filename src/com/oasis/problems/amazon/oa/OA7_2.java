package com.oasis.problems.amazon.oa;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.jws.Oneway;

/**
 * 给一个int[] 找出所有含不超过k个奇数的subarray的数目
 */

// 利用重写hashcode去重 或者 转化为字符串去重，千万不可以 在set输入list
class Solution7_2 {

    public int findSubarrau(int[] arr, int n, int k) {
        Set<String> res= new HashSet<>();
        int[] prefix = new int[arr.length];
        int count = 0;
        for(int i = 0; i < prefix.length; i++){
            if(arr[i] % 2 != 0){
                count++;
            }
            prefix[i] = count;
        }
        for(int i = 0; i < arr.length; i++){
            List<Integer> subList = new ArrayList<>();
            int subtract = i==0 ? 0 : prefix[i-1];
            int j = i;
            while(j < arr.length && prefix[j]-subtract<=k){
                subList.add(arr[j]);
                res.add(getString(subList));
                subList = new ArrayList<>(subList);
                j++;
            }
            res.add(getString(subList));
        }
        System.out.println(res);
        return res.size();
    }

    private String getString(List<Integer> list) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Integer i: list) {
            stringBuilder.append(i);
            stringBuilder.append("+");
        }
        return stringBuilder.toString();
    }

}

public class OA7_2 {
    public static void main(String[] args) {
        Solution7_2 solution = new Solution7_2();
        int[] arr = new int[]{1, 2, 3, 4, 5, 7};
        int k = 2;
        System.out.println(solution.findSubarrau(arr, arr.length, k));
    }
}
