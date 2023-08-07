package leetcodeTest;

import java.util.concurrent.Semaphore;

public class ParkingLotTest {
   private static final int MAX_AVAILABLE = 5;
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(MAX_AVAILABLE);
        for(int i = 1; i <=10; i++){
            new ParkingLot(semaphore, i).start();
        }
    }
}

class ParkingLot extends Thread{
    private Semaphore semaphore;
    private  int num;

    //当前第几个线程
    ParkingLot(Semaphore semaphore, int num){
        this.semaphore = semaphore;
        this.num = num;
    }
    @Override
    public void run() {
        try {
            //汽车驶入停车场，获取permit
            semaphore.acquire();
            System.out.println(this.num+" ---> Entered the parking lot");
            Thread.sleep(500);
            System.out.println(this.num+" ---> Leaved the parking lot");
            semaphore.release();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
