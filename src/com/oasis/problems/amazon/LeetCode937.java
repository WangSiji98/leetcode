package com.oasis.problems.amazon;

import java.util.Arrays;
import java.util.Comparator;

public class LeetCode937 {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(
            logs,
            (o1, o2) -> {
                String[] split1 = o1.split(" ", 2);
                String[] split2 = o2.split(" ", 2);
                boolean dightFlag1 = Character.isDigit(split1[1].charAt(0));
                boolean dightFlag2 = Character.isDigit(split2[1].charAt(0));
                if (!dightFlag1 && !dightFlag2) {
                    if (!split1[1].equals(split2[1])) {
                        return split1[1].compareTo(split2[1]);
                    } else {
                        return split1[0].compareTo(split2[0]);
                    }
                } else if (dightFlag1 && dightFlag2) {
                    return 0;
                } else if (!dightFlag1) {
                    return -1;
                } else {
                    return 1;
                }
            }
        );
        return logs;
    }

    public static void main(String[] args) {
        LeetCode937 leetCode937 = new LeetCode937();
        String[] logs = new String[]{"let1 xrt can","dig2 3 6","let2 own kit dig"};
        System.out.println(Arrays.toString(leetCode937.reorderLogFiles(logs)));
    }
}
