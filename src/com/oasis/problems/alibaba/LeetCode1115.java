package com.oasis.problems.alibaba;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * class FooBar {
 *   public void foo() {
 *      for (int i = 0; i < n; i++) {
 *          print("foo");
 *    }
 *   }
 *
 *   public void bar() {
 *      for (int i = 0; i < n; i++) {
 *          print("bar");
 *      }
 *   }
 * }
 * 两个不同的线程将会共用一个 FooBar实例。其中一个线程将会调用foo()方法，另一个线程将会调用bar()方法。
 *
 * 请设计修改程序，以确保 "foobar" 被输出 n 次。
 *
 * exampole
 * 输入: n = 2
 * 输出: "foobarfoobar"
 * 解释: "foobar" 将被输出两次。
 */

/****************************************************************************************************************************************************************/


/**
 * 原始类
  */
class FooBar {
    private int n;

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
        }
    }
}

/****************************************************************************************************************************************************************/

/**
 * 信号量 semaphore
 * acquire() - 1
 * release() + 1
 */
class FooBarSemaphore {
    private int n;

    private Semaphore fooSema = new Semaphore(1);
    private Semaphore barSema = new Semaphore(0);

    public FooBarSemaphore(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            fooSema.acquire();//值为1的时候，能拿到，执行下面的操作，然后-1
            printFoo.run();
            barSema.release();//释放许可给barSema这个信号量 barSema 的值+1
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            barSema.acquire();//值为1的时候，能拿到，执行下面的操作.然后-1
            printBar.run();
            fooSema.release();//释放许可给fooSema这个信号量 fooSema 的值+1
        }
    }
}

/****************************************************************************************************************************************************************/

/**
 * public CyclicBarrier(int parties)
 * public CyclicBarrier(int parties, Runnable barrierAction)
 * // -构造方法
 * //parties 是参与线程的个数
 * //第二个构造方法有一个 Runnable 参数，这个参数的意思是最后一个到达线程要做的任务
 *   ---
 * public int await() throws InterruptedException, BrokenBarrierException
 * public int await(long timeout, TimeUnit unit) throws InterruptedException, BrokenBarrierException, TimeoutException
 * //- 函数
 * //线程调用 await() 表示自己已经到达栅栏
 * //BrokenBarrierException 表示栅栏已经被破坏，破坏的原因可能是其中一个线程 await() 时被中断或者超时
 * //调用await方法的线程告诉CyclicBarrier自己已经到达同步点，然后当前线程被阻塞。直到parties个参与线程调用了await方法
 *
 * CyclicBarrier 与 CountDownLatch 区别
 * CountDownLatch 是一次性的，CyclicBarrier 是可循环利用的，到条件了会自动重置
 * CountDownLatch 参与的线程的职责是不一样的，有的在倒计时，有的在等待倒计时结束。CyclicBarrier 参与的线程职责是一样的

 */

class FooBarCyclicBarrier {
    private int n;

    private CyclicBarrier cb = new CyclicBarrier(2);
    volatile boolean fooExec = true;

    public FooBarCyclicBarrier(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            while (!fooExec) {
                //false的时候，bar线程在执行，foo线程在这此处空转
            }
            //打印foo
            printFoo.run();
            //设置变量
            fooExec = false;
            try {
                //线程foo到达同步点
                cb.await();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            try {
                cb.await();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            printBar.run();
            fooExec = true;

        }
    }
}

/****************************************************************************************************************************************************************/

/**
 * .yiled() 让步，给同一优先级的其他线程
 */

class FooBarYield {
    private int n;
    //foo可以执行
    volatile boolean fooExec = true;

    public FooBarYield(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; ) {
            if (fooExec) {
                printFoo.run();
                fooExec = false;
                i++;
            } else {
                Thread.yield();
            }

        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; ) {
            if (!fooExec) {
                printBar.run();
                fooExec = true;
                i++;
            } else {
                Thread.yield();
            }

        }
    }
}

/****************************************************************************************************************************************************************/

/**
 * ReentrantLock主要利用CAS+AQS队列来实现。它支持公平锁和非公平锁，两者的实现类似。
 *
 * CAS：Compare and Swap，比较并交换。CAS有3个操作数：内存值V、预期值A、要修改的新值B。当且仅当预期值A和内存值V相同时，将内存值V修改为B，否则什么都不做。该操作是一个原子操作，被广泛的应用在Java的底层实现中。在Java中，CAS主要是由sun.misc.Unsafe这个类通过JNI调用CPU底层指令实现
 *
 * ReentrantLock和synchronized比较
 * 1.ReentrantLock和synchronized都是独占锁,只允许线程互斥的访问临界区。但是实现上两者不同:synchronized加锁解锁的过程是隐式的,用户不用手动操作,优点是操作简单，但显得不够灵活。一般并发场景使用synchronized的就够了；ReentrantLock需要手动加锁和解锁,且解锁的操作尽量要放在finally代码块中,保证线程正确释放锁。ReentrantLock操作较为复杂，但是因为可以手动控制加锁和解锁过程,在复杂的并发场景中能派上用场。
 *
 * 2.ReentrantLock和synchronized都是可重入的。synchronized因为可重入因此可以放在被递归执行的方法上,且不用担心线程最后能否正确释放锁；而ReentrantLock在重入时要却确保重复获取锁的次数必须和重复释放锁的次数一样，否则可能导致其他线程无法获得该锁
 *
 * n=5的时候，已经显示TLE了
 */

class FooBarReentrantLock {
    private int n;
    private ReentrantLock lock = new ReentrantLock(true);
    volatile boolean fooExec = true;

    public FooBarReentrantLock(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; ) {
            lock.lock();
            try {
                if (fooExec) {
                    printFoo.run();
                    fooExec = false;
                    i++;
                }
            } finally {
                lock.unlock();
            }

        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; ) {
            lock.lock();
            try {
                if (!fooExec) {
                    printBar.run();
                    fooExec = true;
                    i++;
                }
            } finally {
                lock.unlock();
            }
        }
    }
}

/****************************************************************************************************************************************************************/

/**
 * SynchronousQueue： 一个不存储元素的阻塞队列，每一个put操作必须等待take操作，否则不能添加元素。支持公平锁和非公平锁。SynchronousQueue的一个使用场景是在线程池里。Executors.newCachedThreadPool()就使用了SynchronousQueue，这个线程池根据需要（新任务到来时）创建新的线程，如果有空闲线程则会重复使用，线程空闲了60秒后会被回收。
 *
 * LinkedBlockingDeque： 一个由链表结构组成的双向阻塞队列。队列头部和尾部都可以添加和移除元素，多线程并发时，可以将锁的竞争最多降到一半
 *
 * add(obj):把obj加到BlockingQueue里,如果BlockQueue没有空间,则调用此方法的线程被阻断直到BlockingQueue里面有空间再继续.
 *
 * take():取走BlockingQueue里排在首位的对象,若BlockingQueue为空,阻断进入等待状态直到BlockingQueue有新的数据被加入;
 */

class FooBarBlockingQueue {
    private int n;
    private BlockingQueue<Integer> fooQueue = new LinkedBlockingQueue<Integer>() {{
        add(0);
    }};
    private BlockingQueue<Integer> barQueue = new LinkedBlockingQueue<>();

    public FooBarBlockingQueue(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            fooQueue.take();
            printFoo.run();
            barQueue.add(0);
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            barQueue.take();
            printBar.run();
            fooQueue.add(0);
        }
    }
}

/****************************************************************************************************************************************************************/

/**
 * 1、wait()、notify/notifyAll() 方法是Object的本地final方法，无法被重写。
 *
 * 2、wait()使当前线程阻塞，前提是 必须先获得锁，一般配合synchronized 关键字使用，即，一般在synchronized 同步代码块里使用 wait()、notify/notifyAll() 方法。
 *
 * 3、 由于 wait()、notify/notifyAll() 在synchronized 代码块执行，说明当前线程一定是获取了锁的。
 *
 * 当线程执行wait()方法时候，会释放当前的锁，然后让出CPU，进入等待状态。
 *
 * 只有当 notify/notifyAll() 被执行时候，才会唤醒一个或多个正处于等待状态的线程，然后继续往下执行，直到执行完synchronized 代码块的代码或是中途遇到wait() ，再次释放锁。
 *
 * 也就是说，notify/notifyAll() 的执行只是唤醒沉睡的线程，而不会立即释放锁，锁的释放要看代码块的具体执行情况。所以在编程中，尽量在使用了notify/notifyAll() 后立即退出临界区，以唤醒其他线程让其获得锁
 *
 * 4、wait() 需要被try catch包围，以便发生异常中断也可以使wait等待的线程唤醒。
 *
 * 5、notify 和wait 的顺序不能错，如果A线程先执行notify方法，B线程在执行wait方法，那么B线程是无法被唤醒的。
 *
 * 6、notify 和 notifyAll的区别
 *
 * notify方法只唤醒一个等待（对象的）线程并使该线程开始执行。所以如果有多个线程等待一个对象，这个方法只会唤醒其中一个线程，选择哪个线程取决于操作系统对多线程管理的实现。notifyAll 会唤醒所有等待(对象的)线程，尽管哪一个线程将会第一个处理取决于操作系统的实现。如果当前情况下有多个线程需要被唤醒，推荐使用notifyAll 方法。比如在生产者-消费者里面的使用，每次都需要唤醒所有的消费者或是生产者，以判断程序是否可以继续往下执行。
 *
 * 7、在多线程中要测试某个条件的变化，使用if 还是while？
 *
 * 要注意，notify唤醒沉睡的线程后，线程会接着上次的执行继续往下执行。所以在进行条件判断时候，可以先把 wait 语句忽略不计来进行考虑；显然，要确保程序一定要执行，并且要保证程序直到满足一定的条件再执行，要使用while进行等待，直到满足条件才继续往下执行
 */

class FooBarSynchronized {
    private int n;
    private Object obj = new Object();
    private volatile boolean fooExec = true;

    public FooBarSynchronized(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            synchronized (obj) {
                if (!fooExec) {//fooExec为false时，该线程等待，为true的时候执行下面的操作
                    obj.wait();
                }
                printFoo.run();
                fooExec = false;
                obj.notifyAll();//唤醒其他线程
            }

        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            synchronized (obj) {
                if (fooExec) {
                    obj.wait();
                }
                printBar.run();
                fooExec = true;
                obj.notifyAll();
            }

        }
    }
}

/****************************************************************************************************************************************************************/

/**
 * LockSupport类的核心方法其实就两个：park()和unpark()，其中park()方法用来阻塞当前调用线程，unpark()方法用于唤醒指定线程。
 * 这其实和Object类的wait()和signal()方法有些类似，但是LockSupport的这两种方法从语意上讲比Object类的方法更清晰，而且可以针对指定线程进行阻塞和唤醒。
 * LockSupport类使用了一种名为Permit（许可）的概念来做到阻塞和唤醒线程的功能，可以把许可看成是一种(0,1)信号量（Semaphore），但与 Semaphore 不同的是，许可的累加上限是1。
 * 初始时，permit为0，当调用unpark()方法时，线程的permit加1，当调用park()方法时，如果permit为0，则调用线程进入阻塞状态。
 */

class FooBarLockSupport {
    private int n;
    private Map<String, Thread> map = new ConcurrentHashMap<>();
    private volatile boolean fooExec = true;

    public FooBarLockSupport(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        map.put("foo", Thread.currentThread());
        for (int i = 0; i < n; i++) {
            while (!fooExec) {
                LockSupport.park();
            }
            printFoo.run();
            fooExec = false;
            LockSupport.unpark(map.get("bar"));
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        map.put("bar", Thread.currentThread());
        for (int i = 0; i < n; i++) {
            while (fooExec) {
                LockSupport.park();
            }
            printBar.run();
            fooExec = true;
            LockSupport.unpark(map.get("foo"));
        }
    }
}
/****************************************************************************************************************************************************************/
public class LeetCode1115 {
    public static void main(String[] args) throws IOException {
        //打印10次foo bar
        FooBarSemaphore fooBar = new FooBarSemaphore(10);
        Runnable printFoo = () -> {
            System.out.print("foo");
        };
        Runnable printBar = () -> {
            System.out.print("bar");
        };
        Thread fooThread = new Thread(() -> {
            try {
                fooBar.foo(printFoo);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread barThread = new Thread(() -> {
            try {
                fooBar.bar(printBar);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        fooThread.start();
        barThread.start();

    }

}
