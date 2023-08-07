package threadsafety;


class Account{

    private double amount = 0;

    public double getAmount() {
        return amount;
    }

    public synchronized void deposit(double num){
        if(amount >= 0){
            amount += num;
        }
        System.out.println(Thread.currentThread().getName() +" --->deposit "
        + this.amount);
    }

    public synchronized void withdraw(double num){
        if(amount > 0){
            amount -= num;
        }
    }
}

class Customer extends Thread{
    private Account account;

    public Customer(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        for(int i = 0; i < 3; i++){
            account.deposit(1000);
        }
    }
}
public class AccountTest {

    public static void main(String[] args) {
        Account account = new Account();
        Customer customer = new Customer(account);
        Customer customer1 = new Customer(account);

        customer1.start();
        customer.start();
    }
}
