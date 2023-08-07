package Singleton;

public class BankTest {
}

class Bank{

    private Bank(){};

    private static Bank bank;

//    public static synchronized Bank getBank(){
//        if(bank == null){
//            bank = new Bank();
//        }
//        return bank; 效率低
//    }

    public static Bank getBank(){
        if(bank == null){
            synchronized (Bank.class){
                if(bank == null){
                    bank = new Bank();
                }
            }
        }

        return bank;
    }
}
