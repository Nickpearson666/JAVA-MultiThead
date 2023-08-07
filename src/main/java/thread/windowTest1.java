package thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 开发当中， 优先Runnable方式
 * 没有类的单继承的限制
 * 可以更方便的实现数据的共享
 *
 * Thread类本身也是实现了runnable接口
 *
 *
 */
class window2 implements Runnable{
    private int tickets = 100;

    //多线程中的共享变量如何操作？
    //private static final AtomicInteger counter = new AtomicInteger(100);

    @Override
    public void run() {
        while(true){
            if(tickets > 0){
                System.out.println(Thread.currentThread().getName() + " ->"+tickets);
                tickets--;
            }else {
                break;
            }
        }

    }
}
public class windowTest1 {

    public static void main(String[] args) {

        window2 window1 = new window2();
        //they share the same tickets
        new Thread(window1).start();
        new Thread(window1).start();
        new Thread(window1).start();
        //they dont share the same tickets
//        new Thread(new window2()).start();
//        new Thread(new window2()).start();


    }
}
