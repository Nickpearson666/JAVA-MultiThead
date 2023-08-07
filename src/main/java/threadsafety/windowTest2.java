package threadsafety;

/**
 * 同步方法实现数据安全 Runnable实现类
 *
 */
class window3 implements Runnable{
    private static int tickets = 100;

    private static final Object obj = new Object();

    //synchronized 加在run方法上是对window3加锁
    @Override
    public void run() {
        while(true){
            if(!helper()){
                break;
            }
        }

    }

    private synchronized boolean helper(){ //this
        if(tickets > 0){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + "->"+tickets);
            tickets--;
            return true;
        }else{
            return false;
        }
    }
}

public class windowTest2 {

    public static void main(String[] args) {
        window3 window3 = new window3();
        //they share the same tickets
        new Thread(window3).start();
        new Thread(window3).start();
        new Thread(window3).start();
    }
}
