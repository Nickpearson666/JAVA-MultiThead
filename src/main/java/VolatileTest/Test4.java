package VolatileTest;

/**
 * volatile 并不能保证原子性
 * 对数据的操作， count++; 先从主内存中读取， +1之后写回主内存
 * 多个线程可能读取到同一样的值， volatile修饰的变量也是线程不安全的
 * 保证数据安全 需要使用锁
 */
public class Test4 {

    public static void main(String[] args) {
        MyThread4 myThread4 = new MyThread4();
        for(int i = 0; i < 100; i++){
            new Thread(myThread4).start();
        }
    }
}

class MyThread4 implements  Runnable{

    private volatile  int count = 0;

    @Override
    public synchronized void run() {
        for(int i = 1; i <= 100; i++){
            count++;
            System.out.println(Thread.currentThread().getName()+" ---> "+ count);
        }
    }
}
