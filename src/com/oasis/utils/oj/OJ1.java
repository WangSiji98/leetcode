package com.oasis.utils.oj;
import java.util.Scanner;

/*
输入包括两个正整数a,b(1 <= a, b <= 10^9),输入数据包括多组。

输出a+b的结果
 */
public class OJ1 {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int a=scanner.nextInt();
            int b=scanner.nextInt();
            System.out.println(a+b);
        }
    }
}
