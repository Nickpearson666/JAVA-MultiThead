package threadsafety;

/**
 *JAVA 解决同步问题
 * 同步代码块 解决 Runnable 实现类
 *
 *
 *
 */
class window2 implements Runnable{
    private int tickets = 100;
    private final Object obj = new Object();

    //多线程中的共享变量如何操作？
    //private static final AtomicInteger counter = new AtomicInteger(100);

    @Override
    public void run() {
        while(true){
            //obj 同步锁 要求多个线程share一把锁
            //任何一个类的对象
            //synchronized (obj){
            //this 锁住当前的对象 window2
            synchronized (this){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                if(tickets > 0){
                    System.out.println(Thread.currentThread().getName() + " ->"+tickets);
                    tickets--;
                }else {
                    break;
                }
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
