package com.oasis.utils.oj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/*
多个测试用例，每个测试用例一行。
每行通过空格隔开，有n个字符，n＜100

对于每组测试用例，输出一行排序过的字符串，每个字符串通过空格隔开
 */
public class OJ9 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        while (scanner.hasNext()){
            String[] strs = scanner.nextLine().split(" ");
            Arrays.sort(strs);
            System.out.println(Arrays.toString(strs));
        }
    }

}
