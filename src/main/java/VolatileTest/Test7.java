package VolatileTest;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class Test7 {
    private  int a = 1;
    private  volatile  int b = 1;

    public void write(){
        a = 3;
        b = a;
        //volatile在这里建立了happens - before 的关系
        //即11行之前的操作均需要对其他线程可见
    }

    public void read(){
        System.out.println("b = "+b+", a = " + a);
    }

    public static void main(String[] args) {
        Test7 test7 = new Test7();
       //
        new Thread(test7::write).start();
        new Thread(test7::read).start();
        InvocationHandler myHandler = (InvocationHandler)(proxy, method, arg) -> method.invoke(proxy, arg);
//        new InvocationHandler(){
//
//            @Override
//            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                return method.invoke(proxy,args);
//            }
//        };

    }

}
