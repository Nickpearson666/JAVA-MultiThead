package DeadLockTest;

public class Test1 {

    public static void main(String[] args) {
        int a = -1;
//        try{
//            a =  8/0;
//        }catch (Exception e){
//            e.printStackTrace();
//        }finally {
//            System.out.println("I am out!!!");
//        }

        try{
            a =  8/0;
        }finally {
            System.out.println("I am out ~~~~!!!");
        }
    }
}
