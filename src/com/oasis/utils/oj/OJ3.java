package com.oasis.utils.oj;

import java.util.Scanner;

/*
输入包括两个正整数a,b(1 <= a, b <= 10^9),输入数据有多组, 如果输入为0 0则结束输入

输出a+b的结果
 */
public class OJ3 {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int a=scanner.nextInt();
            int b=scanner.nextInt();
            if (a == 0 && b == 0) {
                break;
            }
            System.out.println(a+b);
        }
    }
}
