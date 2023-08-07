package DeadLockTest;

public class TransferAccount implements ITransfer {

    @Override
    public void transfer(UserAccount from, UserAccount to, int amount)
            throws InterruptedException {
        synchronized (from){//先锁转出
            System.out.println(Thread.currentThread().getName()
                    +" get"+from.getName());
            Thread.sleep(100);
            synchronized (to){//再锁转入
                System.out.println(Thread.currentThread().getName()
                        +" get"+to.getName());
                from.flyMoney(amount);
                to.addMoney(amount);
            }
        }
    }
}

