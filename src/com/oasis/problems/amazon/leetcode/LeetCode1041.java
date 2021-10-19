package com.oasis.problems.amazon.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LeetCode1041 {
    private static Map<Character, int[]> DIR = new HashMap<Character, int[]>(){{
        put('N', new int[]{0, 1});
        put('W', new int[]{-1, 0});
        put('S', new int[]{0, -1});
        put('E', new int[]{1, 0});
    }};

    private static Map<Character, Character> LEFT = new HashMap<Character, Character>(){{
        put('N', 'W');
        put('W', 'S');
        put('S', 'E');
        put('E', 'N');
    }};

    private static Map<Character, Character> RIGHT = new HashMap<Character, Character>(){{
        put('N', 'E');
        put('E', 'S');
        put('S', 'W');
        put('W', 'N');
    }};

    public boolean isRobotBounded(String instructions) {
        char originDir = 'N';
        char curDir = originDir;
        int curX = 0, curY = 0;
        char[] instructionArray = instructions.toCharArray();
        for (char ins: instructionArray) {
            if (ins == 'L') {
                curDir = LEFT.get(curDir);
            } else if (ins == 'R') {
                curDir = RIGHT.get(curDir);
            } else {
                curX += DIR.get(curDir)[0];
                curY += DIR.get(curDir)[1];
            }
        }
        return (curX == 0 && curY == 0) || curDir != 'N';
    }

    public static void main(String[] args) {
        LeetCode1041 leetCode1041 = new LeetCode1041();
        String instructions = "GGLLGG";
        System.out.println(leetCode1041.isRobotBounded(instructions));
    }

}
