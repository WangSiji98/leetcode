package com.oasis.test;

public class Test1 {
    public static void main(String[] args) {
        byte a = 0;
        int[] cells = new int[]{0 , 1, 1, 1, 0, 1, 0 ,1};
        for (int i = 0; i < 8; ++i) {
            System.out.println((cells[i] & 1) << i);
            a ^= ((cells[i] & 1) << i);
        }
        System.out.println(a);
    }

}
