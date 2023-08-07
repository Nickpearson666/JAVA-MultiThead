package VolatileTest;

/**
 * 多线程下， 变量的不可见性
 * JMM： java memo model
 * 每一个子线程都有对应自己的工作内存， 从主内存中拷贝一份数据
 * 如果另一个线程没有读取到最新修改后的数据， 就会出现错误
 * 所有的共享变量都在主内存中
 *
 */
public class Test1 {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();

        while (true){
            if(myThread.isFlag()){
                System.out.println("Flag has changed!!!");
            }
        }
    }
}

class MyThread extends Thread{

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
