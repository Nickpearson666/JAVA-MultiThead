package thread;


class MyThread extends Thread{
    @Override
    public void run() {
        for(int i = 0; i <= 10; i++){
            if((i&1) == 1){
                System.out.println("odd!");
            }else{
                System.out.println("Even!");
            }
        }
    }
}
public class ThreadTest {
    public static void main(String[] args) {
        //new MyThread().start();
        //start 方法 1 启动当前线程 2 调佣当前线程的run方法
        //每一个线程 start仅执行一次

        new Thread(){
            @Override
            public void run() {
                getNum();
            }
        }.start();

        //实现runable接口， 使用方法引用
        new Thread(ThreadTest::getNum).start();

    }

    public static void getNum(){
        for(int i = 0; i <= 10; i++){
            if((i&1) == 1){
                System.out.println("odd!");
            }else{
                System.out.println("Even!");
            }
        }
    }

}
