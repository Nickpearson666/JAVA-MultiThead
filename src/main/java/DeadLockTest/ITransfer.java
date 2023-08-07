package DeadLockTest;

public interface ITransfer {
    /**@param from 转出账户
     * @param to 转入账户
     * @param amount 转账金额
     * @throws InterruptedException
     */
    void transfer(UserAccount from, UserAccount to, int amount) throws InterruptedException;

}
