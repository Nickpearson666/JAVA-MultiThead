package thread;

/**
 * Thread.yield() 释放CPU的执行权
 * join() A线程中调用B线程join, A进入阻塞状态， 直到线程B执行完毕，A结束阻塞状态
 * stop() 强制结束线程 不推荐使用
 * sleep() 休眠, 让出CPU，进入阻塞状态
 *
 * 线程的优先级
 * 1. max = 10, min = 1, norm = 5
 * 2. 设置set/get priority优先级
 *
 */
public class ThreadMethodTest {

    public static void main(String[] args) {
        Thread a = new Thread(new ThreadMethodTest()::sleepTest);
        //被CPU调度的概率比较高
        Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
        a.start();
        for(int i = 0; i <= 100; i++){
            System.out.println("currThread: "+ Thread.currentThread().getName()+" "+i);
            if(i == 20){
                try {
                    a.join();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }

    public void getNum(){
        for(int i = 0; i <=100; i++){
            if((i&1) == 0){
                System.out.println("currThread: "+ Thread.currentThread().getName() + " "+i);
            }
//            if(i % 20 == 0){
//                //让出CPU， 执行其他线程
//                Thread.yield();
//            }


//            if(i == 20){
//                try {
//                    Thread.currentThread().join();
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//            }
        }
    }

    public void sleepTest(){
        for(int i = 0; i <= 100; i++){
            System.out.println("currThread: "+ Thread.currentThread().getName() + " "+i);
            if(i == 20){
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

}
