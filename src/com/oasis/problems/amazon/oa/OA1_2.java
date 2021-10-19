package com.oasis.problems.amazon.oa;

import java.util.ArrayList;
import java.util.List;

/**
 * 2.Decode the input string into original string.
 *
 * You are given an encoded string  and number of rows, Convert it to original string
 *
 *  Input: mnesi___ya__k____mime  N = 3
 *
 *  Output : my name is mike
 *
 *  Explanation : Read the matrix in a diagonal way starting from [0][0] index until the end of row and start from the top
 *  again to decode it. _ are treated as space.
 *
 *  m n e s i _ _
 *  _ y a _ _ k _
 *  _ _ _ m i m e
 *
 *   https://leetcode.com/discuss/interview-question/1317796/amazon-oa-2021-hackerrank
 */

public class OA1_2 {
    public String decodeString(String s, int row) {
        int n = s.length();
        List<String> list = new ArrayList<>();
        int lenOfRow = n / row;
        for (int i = 0; i < row; ++i) {
            list.add(s.substring(i * lenOfRow, (i + 1) * lenOfRow));
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i <= lenOfRow - row; ++i) {
            for (int j = 0; j < row; ++j) {
                char ch = list.get(j).charAt(i + j);
                if (ch == '_') {
                    stringBuilder.append(" ");
                } else {
                    stringBuilder.append(ch);
                }
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        OA1_2 oa1_2 = new OA1_2();
        String s = "mnesi___ya__k____mime";
        int n = 3;
        System.out.println(oa1_2.decodeString(s, n));
    }

}
