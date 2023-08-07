package DeadLockTest;

public class SafeLock implements ITransfer {
    private static Object tieLock = new Object();//哈希冲突时使用的锁
    @Override
    public void transfer(UserAccount from, UserAccount to, int amount)
            throws InterruptedException {
        //利用System.identityHashCode 维持加锁的顺序一致
        int fromHash = System.identityHashCode(from);
        int toHash = System.identityHashCode(to);
        //先锁hash小的那个
        if(fromHash<toHash) {
            synchronized (from){
                System.out.println(Thread.currentThread().getName()
                        +" get "+from.getName());
                Thread.sleep(100);
                synchronized (to){
                    System.out.println(Thread.currentThread().getName()
                            +" get "+to.getName());
                    from.flyMoney(amount);
                    to.addMoney(amount);
                }
            }
        }else if(toHash<fromHash) {
            synchronized (to){
                System.out.println(Thread.currentThread().getName()
                        +" get "+to.getName());
                Thread.sleep(100);
                synchronized (from){
                    System.out.println(Thread.currentThread().getName()
                            +" get "+from.getName());
                    from.flyMoney(amount);
                    to.addMoney(amount);
                }
            }
        }else {//解决hash冲突的方法
            synchronized (tieLock) {
                synchronized (from) {
                    synchronized (to) {
                        from.flyMoney(amount);
                        to.addMoney(amount);
                    }
                }
            }
        }
    }
}