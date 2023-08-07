package VolatileTest;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * AtomicInteger JDK 提供的可以保证原子性 同时不需要加锁
 * 底层   CAS 锁
 */
public class Test5 {

    public static void main(String[] args) {
        MyThread5 myThread5 = new MyThread5();
        for(int i = 0; i < 100; i++){
            new Thread(myThread5).start();
        }
    }
}

class MyThread5 implements  Runnable{

    private final AtomicInteger count = new AtomicInteger(1);

    private  final  int a = 1;

    @Override
    public synchronized void run() {
        //这里是不被允许的， final修饰的类中的属性 表示对应的引用 全局不能改变
        //count = new AtomicInteger(1);
        for(int i = 1; i <= 1000; i++){
            System.out.println(Thread.currentThread().getName()+" ---> "+ count.getAndAdd(1));
        }
    }
}
