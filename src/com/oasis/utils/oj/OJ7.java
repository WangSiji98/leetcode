package com.oasis.utils.oj;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
输入数据有多组, 每行表示一组输入数据。
每行不定有n个整数，空格隔开。(1 <= n <= 100)。

每组数据输出求和的结果
 */
public class OJ7 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        while (scanner.hasNext()){
            String[] strs = scanner.nextLine().split(" ");
            int total = 0;
            for (String str : strs) {
                total += Integer.parseInt(str);
            }
            list.add(total);
        }
        for (int num : list) {
            System.out.println(num);
        }

    }
}
