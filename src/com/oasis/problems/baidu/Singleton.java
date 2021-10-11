package com.oasis.problems.baidu;

// 双重锁
class SingletonDCL {
    private static volatile SingletonDCL singletonDCL;

    private SingletonDCL() {}

    public static SingletonDCL getInstance() {
        try {
            if (singletonDCL == null) {
                synchronized (SingletonDCL.class) {
                    if (singletonDCL == null) {
                        singletonDCL = new SingletonDCL();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return singletonDCL;
    }
}

// 静态内部类
class SingletonStaticInner {
    private SingletonStaticInner() {

    }
    private static class SingletonInner {
        private static SingletonStaticInner singletonStaticInner = new SingletonStaticInner();
    }
    public static SingletonStaticInner getInstance() {
        return SingletonInner.singletonStaticInner;
    }
}


public class Singleton {

}
