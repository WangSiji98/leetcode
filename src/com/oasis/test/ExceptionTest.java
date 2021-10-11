package com.oasis.test;

class Test {
    public int aMethod(int i) throws Exception {
        return 1 / i;
    }
}

public class ExceptionTest {
    public static void main(String[] args) {
        Test test = new Test();
        try {
            test.aMethod(1);
            throw new Exception();
        } catch (Exception e) {
            System.out.println("抓到了");
        }

    }
}


