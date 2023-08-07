package threadsafety;

/**
 * 同步方法实现数据安全 Thread的子类
 *
 * 同步方法需要考虑同步显示器，但是不需要显式声明
 * 非静态的同步方法 监视器是this
 * 静态是 class类对象
 *
 */
class window4 extends Thread{
    private static int tickets = 100;


    @Override
    public void run() {
        while(true){
            if(!helper()){
                break;
            }
        }

    }

    public static synchronized boolean helper(){
        //static + synchronized 锁的是类window4.class对象
        //synchronized 对象 w1,w2,w3
        if(tickets > 0){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + "->"+tickets);
            tickets--;
            return true;
        }else {
            return false;
        }
    }
}

public class windowTest3 {

    public static void main(String[] args) {
        window4 w1 = new window4();
        window4 w2 = new window4();
        window4 w3 = new window4();

        w1.setName("window[1]");
        w2.setName("window[2]");
        w3.setName("window[3]");

        w1.start();
        w2.start();
        w3.start();
    }
}
