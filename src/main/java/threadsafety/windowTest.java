package threadsafety;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 同步代码块实现数据安全 Thread的子类
 *
 */
class window extends Thread{
    private static int tickets = 100;

    private static final Object obj = new Object();

    //多线程中的共享变量如何操作？
    //private static final AtomicInteger counter = new AtomicInteger(100);

    @Override
    public void run() {
        while(true){
            //synchronized (obj){
            synchronized (window.class){ //windows.class 是一个对象且只加载一次
                if(tickets > 0){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(getName() + "->"+tickets);
                    tickets--;
                }else {
                    break;
                }
            }
        }

    }
}

public class windowTest {

    public static void main(String[] args) {
        window w1 = new window();
        window w2 = new window();
        window w3 = new window();

        w1.start();
        w2.start();
        w3.start();
    }
}
