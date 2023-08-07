package threadsafety;

/**
 * wait 进入同步状态 释放同步监视器
 * notify 唤醒被wait的线程， 如果多个线程被wait 唤起优先级高的那个线程
 * notifyAll 唤醒所有的wait线程
 *
 * 这些线程通信方法使用在同步代码块or同步方法中
 * 这三个方法的调用者必须是同步代码块or同步方法中的监视器 synchronized(this) this.notify
 * 方法定义在object类中
 *
 */
class Number implements Runnable{

    private int number = 0;

    @Override
    public void run() {
//            while(true){
//                synchronized (this){
//                    notify();
//                    if(number <= 100){
//                        number++;
//                        System.out.println(Thread.currentThread().getName()+" ---> "+number);
//                        try {
//                            wait(); //释放锁
//                        } catch (InterruptedException e) {
//                            throw new RuntimeException(e);
//                        }
//                    }else{
//                        break;
//                    }
//                }
//
//            }

        //deadlock
//            synchronized (this){
//                notify();
//                while (true){
//                    if(number <= 100){
//                        number++;
//                        System.out.println(Thread.currentThread().getName()+" ---> "+number);
//                        try {
//                            wait(); //释放锁
//                        } catch (InterruptedException e) {
//                            throw new RuntimeException(e);
//                        }
//                    }else{
//                        break;
//                    }
//                }
//            }

    }
}
public class NumberTest {
    public static void main(String[] args) {
        //Semaphore semaphore = new Semaphore(1);
        Number number = new Number();
        new Thread(number).start();
        new Thread(number).start();
    }
}
