package DeadLockTest;

public class NormalDeadLock {
    //定义两个对象锁
    private static Object valueFirst = new Object();//第一个锁
    private static Object valueSecond = new Object();//第二个锁
    //先拿第一个锁，再拿第二个锁
    private static void fisrtToSecond() throws InterruptedException {
        String threadName = Thread.currentThread().getName();
        synchronized (valueFirst) {
            System.out.println(threadName+" get first");
            Thread.sleep(100);
            synchronized (valueSecond) {
                System.out.println(threadName+" get second");
            }
        }
    }
    //先拿第二个锁，再拿第一个锁
    private static void SecondToFisrt() throws InterruptedException {
        String threadName = Thread.currentThread().getName();
        synchronized (valueFirst) {
            System.out.println(threadName+" get second");
            Thread.sleep(101);
            synchronized (valueSecond) {
                System.out.println(threadName+" get first");
            }
        }
    }
    //执行先拿第二个锁，再拿第一个锁
    private static class TestThread extends Thread{
        private String name;
        public TestThread(String name) {
            this.name = name;
        }
        public void run(){
            Thread.currentThread().setName(name);
            try {
                SecondToFisrt();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        //死锁的根本成因：获取锁的顺序不一致导致。
//        修改建议：
//        1. 每个线程获取锁的顺序是前后一致的；

        Thread.currentThread().setName("TestDeadLock");
        TestThread testThread = new TestThread("SubTestThread");
        testThread.start();
        try {
            fisrtToSecond();//先拿第一个锁，再拿第二个锁
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
