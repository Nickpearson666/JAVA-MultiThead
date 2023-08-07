package thread;

class MyThread2 implements Runnable{

    @Override
    public void run() {
        for(int i = 0; i <=100; i++){
            if((i&1) == 0){
                System.out.println(Thread.currentThread().getName()+"Even: "+ i);
            }
        }
    }
}
public class ThreadTest1{
    public static void main(String[] args) {

        new Thread(new MyThread2()).start();
        new Thread(new MyThread2()).start();
    }
}
