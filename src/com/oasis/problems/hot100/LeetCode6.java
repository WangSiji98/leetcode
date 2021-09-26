package com.oasis.problems.hot100;

import java.util.ArrayList;
import java.util.List;

public class LeetCode6 {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        List<StringBuilder> lineStringList = new ArrayList<StringBuilder>() {{
            for (int i = 0; i < numRows; ++i) {
                add(new StringBuilder());
            }
        }};
        //up 1; down -1
        int direction = 1;
        int currentLine = 0;
        for (char c: s.toCharArray()) {
            lineStringList.get(currentLine).append(c);
            if (currentLine == 0 || currentLine == numRows - 1) {
                direction = currentLine == 0 ? 1 : -1;
            }
            currentLine += direction;
        }
        String result = "";
        for (StringBuilder str: lineStringList) {
            result += str.toString();
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int numRows = 1;
        LeetCode6 leetCode6 = new LeetCode6();
        System.out.println(leetCode6.convert(s, numRows));
    }
}
