package com.oasis.problems.baidu;


import jdk.internal.org.objectweb.asm.tree.TryCatchBlockNode;

// 两个线程 交替打印 数字
class Print1 implements Runnable{

    volatile int i = 1;

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                // 先唤醒另外一个线程
                notify();
                try {
                    Thread.currentThread();
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (i <= 10) {
                    System.out.println(Thread.currentThread().getName() + ":"+ i);
                    i++;
                    try {
                        // 打印完之后，释放资源，等待下次被唤醒
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}

class Print2 implements Runnable {
    volatile int i = 0;

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                notify();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (i % 2 == 0) {
                    System.out.println(Thread.currentThread().getName() + ":" + "A");
                } else {
                    System.out.println(Thread.currentThread().getName() + ":" + "B");
                }
                ++i;
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}



public class ThreadPrint {

    public static void main(String[] args) throws InterruptedException {
//        Print1 t = new Print1();
//        Thread t1 = new Thread(t);
//        Thread t2 = new Thread(t);
        Print2 t = new Print2();
        Thread t1 = new Thread(t);
        Thread t2 = new Thread(t);

        t1.setName("线程1");
        t2.setName("线程2");

        t1.start();
        t2.start();
    }

}
