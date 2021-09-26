package com.oasis.problems.hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class LeetCode406 {
    public int[][] reconstructQueue(int[][] people) {
        int n = people.length;
        Arrays.sort(
            people,
            new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if (o1[0] != o2[0]) {
                        return o1[0] - o2[0];
                    } else {
                        return o2[1] - o1[1];
                    }
                }
            }
        );

        int[][] res =  new int[n][];

        for (int i = 0; i < n; ++i) {
            int blank = people[i][1] + 1;
            for (int j = 0; j < n; ++j) {
                if (Objects.isNull(res[j])) {
                   --blank;
                    if (blank == 0) {
                        res[j] = people[i];
                        break;
                    }
                }

            }
        }
        return res;
    }

    // 更为巧妙的办法，从高到低考虑
    public int[][] reconstructQueue1(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] person1, int[] person2) {
                if (person1[0] != person2[0]) {
                    return person2[0] - person1[0];
                } else {
                    return person1[1] - person2[1];
                }
            }
        });
        List<int[]> ans = new ArrayList<int[]>();
        for (int[] person : people) {
            ans.add(person[1], person);
        }
        return ans.toArray(new int[ans.size()][]);
    }

    public static void main(String[] args) {
        LeetCode406 leetCode406 = new LeetCode406();
        int[][] people = new int[][]{{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        int[][] peoples = leetCode406.reconstructQueue(people);
        for (int[] person : peoples) {
            System.out.println(Arrays.toString(person));
        }
    }

}
