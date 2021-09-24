package com.oasis.utils.oj;

import java.util.Scanner;

/*
输入数据有多组, 每行表示一组输入数据。
每行的第一个整数为整数的个数n(1 <= n <= 100)。
接下来n个正整数, 即需要求和的每个正整数。

每组数据输出求和的结果
 */
public class OJ6 {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int sum = 0;
            int n = scanner.nextInt();
            for (int i = 0; i < n; ++i) {
                sum += scanner.nextInt();
            }
            System.out.println(sum);
        }
    }
}
