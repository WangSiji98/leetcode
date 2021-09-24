package com.oasis.utils.oj;

import java.util.Scanner;

/*
输入第一行包括一个数据组数t(1 <= t <= 100)
接下来每行包括两个正整数a,b(1 <= a, b <= 10^9)

输出a+b的结果
 */
public class OJ2 {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        while(scanner.hasNext()){
            int a=scanner.nextInt();
            int b=scanner.nextInt();
            System.out.println(a+b);
        }
    }
}
