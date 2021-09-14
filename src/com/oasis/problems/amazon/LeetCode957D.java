package com.oasis.problems.amazon;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// 超时 思路是对的
public class LeetCode957D {
    private Map<String, int[]> map;

    public int[] prisonAfterNDays(int[] cells, int n) {
        map = new HashMap<>();
        map.put(getState(cells), new int[]{0, -1});
        int i = 0;
        while (i < n) {
            ++i;
            int[] tmp = new int[8];
            for (int j = 1; j < 7; ++j) {
                if (cells[j - 1] == cells[j + 1]) {
                    tmp[j] = 1;
                } else {
                    tmp[j] = 0;
                }
            }
            cells = tmp;
            String cur = getState(cells);
            if (map.containsKey(cur)) {
                if (map.get(cur)[1] != -1) {
                    if (i + map.get(cur)[1] < n) {
                        i += map.get(cur)[1];
                    }
                } else {
                    map.put(cur, new int[]{map.get(cur)[0], i - map.get(cur)[0]});
                }
            } else {
                map.put(cur, new int[]{i, -1});
            }
        }
        return cells;
    }

    private String getState(int[] cells) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 8; ++i) {
            stringBuilder.append(cells[i]);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        LeetCode957D leetCode957D = new LeetCode957D();
        int[] cells = new int[]{1,0,0,1,0,0,1,0};
        int n = 1000000000;
        System.out.println(Arrays.toString(leetCode957D.prisonAfterNDays(cells, n)));
    }

}
