package VolatileTest;

/**
 * 加锁：
 * 使用synchronized 修饰后， 线程会清空自己的工作内存
 * 会从主内存中读取最新的值
 */
public class Test2 {
    public static void main(String[] args) {
        MyThread2 myThread = new MyThread2();
        myThread.start();
        Object obj = new Object();
        while (true){
            synchronized (obj){
                if(myThread.isFlag()){
                    System.out.println("Flag has changed!!!");
                }
            }
        }
    }
}

class MyThread2 extends Thread{

    private boolean flag = false;
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
