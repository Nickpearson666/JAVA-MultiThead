package VolatileTest;

import java.util.List;

class Y implements Cloneable{
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

class AAAA{

    public static <E> void printArray( E[] inputArray )
    {
        // 输出数组元素
        for ( E element : inputArray ){
            System.out.printf( "%s ", element );
        }
        System.out.println();
    }

    public void listMethod(List<String> stringList){
    }
//    public void listMethod(List<Integer> intList) {
//    }
    public static void main(String[] args) {
        List[] list = new List[10];

        Y y = new Y();
        try {
            y.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
