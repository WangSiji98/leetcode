package com.oasis.utils.oj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/*
输入有两行，第一行n
第二行是n个空格隔开的字符串

输出一行排序后的字符串，空格隔开，无结尾空格
 */
public class OJ8 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            list.add(scanner.next());
        }
        Collections.sort(list);
        System.out.println(list);
    }
}
