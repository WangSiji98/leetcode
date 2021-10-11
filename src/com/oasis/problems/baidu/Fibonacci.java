package com.oasis.problems.baidu;

import java.util.ArrayList;
import java.util.List;

public class Fibonacci {
    public void fibonacci(int n) {
        if (n < 2) {
            return;
        }
        int p = 1;
        int q = 1;
        List<Integer> list = new ArrayList<Integer>(){{
           add(1);
           add(1);
        }};
        for (int i = 2; i < n; ++i) {
            int r = p + q;
            list.add(r);
            p = q;
            q = r;
        }
        System.out.println(list);
    }

    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        fibonacci.fibonacci(10);
    }


}
