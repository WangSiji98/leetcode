package com.oasis.utils.oj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/*
多个测试用例，每个测试用例一行。
每行通过,隔开，有n个字符，n＜100

对于每组用例输出一行排序后的字符串，用','隔开，无结尾空格
 */
public class OJ10 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        while (scanner.hasNext()){
            String[] strs = scanner.nextLine().split(",");
            Arrays.sort(strs);
            System.out.println(Arrays.toString(strs));
        }
    }

}
