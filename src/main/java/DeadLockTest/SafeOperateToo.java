package DeadLockTest;

import java.util.Random;

public class SafeOperateToo implements ITransfer {
    @Override
    public void transfer(UserAccount from, UserAccount to, int amount) throws InterruptedException {
        Random r = new Random();
        while(true) {
            if(from.getLock().tryLock()) {
                // 尝试获取当前锁， 得不到就返回
                try {
                    System.out.println(Thread.currentThread().getName() + " get "+from.getName());
                    if(to.getLock().tryLock()) {
                        try {
                            System.out.println(Thread.currentThread().getName() + " get "+to.getName());
                            //两把锁都拿到了
                            from.flyMoney(amount);
                            to.addMoney(amount);
                            break;
                        }finally {
                            to.getLock().unlock();
                        }
                    }
                }finally {
                    from.getLock().unlock();
                }
            }
            Thread.sleep(r.nextInt(10)); //线程睡眠小技巧，加快取锁
        }
    }
}