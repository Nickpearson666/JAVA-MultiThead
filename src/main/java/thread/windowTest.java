package thread;

import java.util.concurrent.atomic.AtomicInteger;

class window extends Thread{
    //private static int tickets = 100;

    //多线程中的共享变量如何操作？
    private static final AtomicInteger counter = new AtomicInteger(100);

    @Override
    public void run() {
        while(true){
            if(counter.get() > 0){
                System.out.println(getName() + "->"+counter.get());
                counter.decrementAndGet();
            }else {
                break;
            }
        }

    }
}

public class windowTest {

    public static void main(String[] args) {
        window w1 = new window();
        window w2 = new window();
        window w3 = new window();

        w1.start();
        w2.start();
        w3.start();
    }
}
