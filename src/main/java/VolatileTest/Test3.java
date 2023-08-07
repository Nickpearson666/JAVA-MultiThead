package VolatileTest;

/**
 * 使用 volatile 关键字修饰
 * 当线程修改了对应的属性值，其他线程工作内存中的值会失效， 加载最新的值
 */
public class Test3 {
    public static void main(String[] args) {
        MyThread3 myThread = new MyThread3();
        myThread.start();
        Object obj = new Object();
        while (true) {

            if (myThread.isFlag()) {
                System.out.println("Flag has changed!!!");
            }

        }
    }
}

class MyThread3 extends Thread{

    private volatile boolean flag = false;
    @Override
    public  void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        flag = !flag;
    }

    public  boolean isFlag() {
        return flag;
    }
}
