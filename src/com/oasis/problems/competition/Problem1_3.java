package com.oasis.problems.competition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Your DetectSquares object will be instantiated and called as such:
 * DetectSquares obj = new DetectSquares();
 * obj.add(point);
 * int param_2 = obj.count(point);
 */
class DetectSquares {
    private Map<int[], Integer> map;

    public DetectSquares() {
        map = new HashMap<>();
    }

    public void add(int[] point) {
        for (int[] p: map.keySet()) {
            if (point[0] == p[0] && point[1] == p[1]) {
                map.put(p, map.get(p) +1);
                return;
            }
        }
        map.put(point, 1);
    }

    public int count(int[] point) {
        int res = 0;
        for (int[] p: map.keySet()) {
            int ans = check(point, p);
            int n = map.get(p);
            res += ans * n;
        }
        return res;
    }

    // 先横坐标 再纵坐标
    private int check(int[] point1, int[] point2) {
        int x1 = point1[0];
        int x2 = point2[0];
        int y1 = point1[1];
        int y2 = point2[1];
        if (x1 == x2 && y1 == y2) {
            return 0;
        }
        if (Math.abs(x1 - x2) != Math.abs(y1 - y2)) {
            return 0;
        }

        int x3 = x1;
        int y3 = y2;
        int x4 = x2;
        int y4 = y1;

        int numX3 = 0, numX4 = 0;
        for (int[] point: map.keySet()) {
            if (point[0] == x3 && point[1] == y3) {
                numX3 += map.get(point);
            }
            if (point[0] == x4 && point[1] == y4) {
                numX4 += map.get(point);
            }
        }
        return numX3 * numX4;
    }
}

public class Problem1_3 {
    // 斜对角线 可以唯一确定 一个正方形
    public static void main(String[] args) {
        DetectSquares detectSquares = new DetectSquares();
        detectSquares.add(new int[]{3, 10});
        detectSquares.add(new int[]{11, 2});
        detectSquares.add(new int[]{3, 2});
        System.out.println(detectSquares.count(new int[]{11, 10}));
        System.out.println(detectSquares.count(new int[]{14, 8}));
        detectSquares.add(new int[]{11, 2});
        detectSquares.count(new int[]{11, 10});
        System.out.println(detectSquares.count(new int[]{11, 10}));
    }

}
