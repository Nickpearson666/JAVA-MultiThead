package VolatileTest;

public class Test6 {

    //使用volatile关键字可以避免指令重排序
    private static int a = 0, i = 0;

    private static  int b = 0, j = 0;

    public static void main(String[] args) throws InterruptedException {
        int cnt = 0;
        while(true){
            a = 0;
            i = 0;
            b = 0;
            j = 0;
            cnt++;

            /**
             * 此案例演示指令重排 24-25会置换 25->24
             * 执行中 CPU和内存为了提高效率， 当数据不存在冲突时， 可能会出现指令重排
             *
             */
            Thread t1 = new Thread(() -> {
                a = 1;
                i = b;
            });

            Thread t2 = new Thread(() -> {
                b = 1;
                j = a;
            });

            t1.start();
            t2.start();
            t1.join();
            t2.join();
            System.out.println("Curr: "+ cnt + " i= "+i+" j= "+j);
            if(i == 0 && j == 0){
                break;
            }
        }
    }

}
