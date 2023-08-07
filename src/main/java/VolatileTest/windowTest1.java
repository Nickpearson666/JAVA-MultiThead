package VolatileTest;

/**
 *JAVA 解决同步问题
 * 同步代码块 解决 Runnable 实现类
 *
 *
 *
 */
class window2 implements Runnable{
    private volatile  int tickets = 100;

    @Override
    public void run() {
        while (true) {

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (tickets > 0) {
                System.out.println(Thread.currentThread().getName() + " ->" + tickets);
                tickets--;
            } else {
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
    }
}
