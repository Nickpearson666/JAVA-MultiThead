package thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 通过callable接口实现多线程
 * 可以有返回值
 * call方法可以throws方法
 * Callable可以指定泛型，说明返回类型
 */
class MyCallable implements Callable{
    @Override
    public Object call() throws Exception {
        long sum = 0;
        for(int i = 0; i <= 100; i++){
            sum += i;
        }
        return sum;
    }
}
public class CallableTest {
    public static void main(String[] args) {
        FutureTask futureTask = new FutureTask(new MyCallable());
        Thread t1 = new Thread(futureTask);
        t1.start();
        try {
            //futureTask.get() 会阻塞，等待子线程执行完毕
            System.out.println("res" +" "+futureTask.get());
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}
