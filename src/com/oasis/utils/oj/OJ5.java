package com.oasis.utils.oj;

import java.util.Scanner;

/*
输入的第一行包括一个正整数t(1 <= t <= 100), 表示数据组数。
接下来t行, 每行一组数据。
每行的第一个整数为整数的个数n(1 <= n <= 100)。
接下来n个正整数, 即需要求和的每个正整数。

每组数据输出求和的结果
 */
public class OJ5 {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();

        for (int i = 0; i < t; ++i) {
            int sum = 0;
            int n = scanner.nextInt();
            for(int j = 0; j < n; j++){
                sum += scanner.nextInt();
            }
            System.out.println(sum);
        }
    }

}
