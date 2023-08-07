package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 使用线程池，实现多线程
 * 频繁的创建和销毁线程会降低系统的效率
 * 采用提前创建线程池的方式，即拿即用，用完不销毁
 * 优势：
 * 提高程序执行效率
 * 提高资源利用率，执行完的线程并不会销毁，可以复用
 * 设置参数对线程进行管理
 */
public class ThreadPoolTest {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor)executorService;
        System.out.println(threadPoolExecutor.getCorePoolSize()+"aaaaa");
        threadPoolExecutor.setMaximumPoolSize(50);
        System.out.println(threadPoolExecutor.getMaximumPoolSize()+"bbbbbb");
//        //对于runnable接口的线程
//        threadPoolExecutor.execute(new MyThread2());
//        //对于thread的接口
//        threadPoolExecutor.execute(new MyThread());
//        //对于callable的接口 submit
//        threadPoolExecutor.submit(new MyCallable());

        threadPoolExecutor.shutdown();
    }

}
