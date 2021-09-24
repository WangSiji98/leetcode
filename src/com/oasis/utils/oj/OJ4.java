package com.oasis.utils.oj;

import java.util.Scanner;

/*
输入数据包括多组。
每组数据一行,每行的第一个整数为整数的个数n(1 <= n <= 100), n为0的时候结束输入。
接下来n个正整数,即需要求和的每个正整数。

每组数据输出求和的结果
 */
public class OJ4 {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int sum=0;
            int n = scanner.nextInt();
            if(n == 0){
                break;
            }
            for(int i = 0; i < n; i++){
                sum += scanner.nextInt();
            }
            System.out.println(sum);

        }
    }
}
