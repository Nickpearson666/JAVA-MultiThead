package leetcodeTest;

import java.util.concurrent.TimeUnit;

//1115. Print FooBar Alternately
//        Suppose you are given the following code:
//
//class FooBar {
//    public void foo() {
//        for (int i = 0; i < n; i++) {
//            print("foo");
//        }
//    }
//
//    public void bar() {
//        for (int i = 0; i < n; i++) {
//            print("bar");
//        }
//    }
//}
//    The same instance of FooBar will be passed to two different threads:
//
//        thread A will call foo(), while
//        thread B will call bar().
//        Modify the given program to output "foobar" n times.
public class Test1 {

    //semaphore 信号量可以控制同时访问资源的线程个数
    //semaphore 初始化可以表明令牌的数量 permits
    //acquire 获取令牌
    //release 释放令牌
//    semaphore(int permits);
//    semaphore(int permits, boolean fair); //是否采用公平策略获取permit, 即等待时间越久的线程越先获取， 默认是非公平
// 会阻塞的方法：
// acquire() acquire(int permits)
// release() release(int permits)
//    非阻塞方法：[如果获取成功立即返回true, 否则返回false]
//    boolean tryAcquire();
//    boolean tryAcquire(long timeout, TimeUnit timeUnit); 带有超时机制的获取permit
//    boolean tryAcquire(int permits);
//    boolean tryAcquire(int permits,long timeout, TimeUnit timeUnit)
    // availablePermits() 获取对当前可用的信号量数目
//    可以用作限流

}
