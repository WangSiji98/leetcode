package com.oasis.problems.amazon.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LeetCode1268 {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(
            products,
            new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return o1.compareTo(o2);
                }
            }
        );

        int n = searchWord.length();
        List<List<String>> res = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            List<String> ans = new ArrayList<>();
            int index = binarySearch(products, searchWord.substring(0,i + 1));
            for (int j = index; j < Math.min(index + 3, products.length); ++j) {
                if (products[j].length() > i && searchWord.substring(0, i + 1).equals(products[j].substring(0, i + 1))) {
                    ans.add(products[j]);
                }
            }
            res.add(ans);
        }
        return res;
    }

    // 用的是第三种 二分查找 模板
    private int binarySearch(String[] products, String searchWord) {
        int l = 0, r = products.length - 1;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (products[mid].compareTo(searchWord) >= 0) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return r;
    }

    public static void main(String[] args) {
        LeetCode1268 leetCode1268 = new LeetCode1268();
        String[] products = new String[]{"mobile","mouse","moneypot","monitor","mousepad"};
        String searchWord = "mouse";
        System.out.println(leetCode1268.suggestedProducts(products, searchWord));
    }

}
