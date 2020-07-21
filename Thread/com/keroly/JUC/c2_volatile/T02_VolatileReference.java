package com.keroly.JUC.c2_volatile;
import java.util.concurrent.TimeUnit;

public class T02_VolatileReference {
    boolean running = true;

    /**
     * volatile 引用类型（包括数组）只能保证引用本身的可见性，不能保证内部字段的可见性
     */

    volatile static T02_VolatileReference T = new T02_VolatileReference();

    void m() {
        System.out.println("m start");
        while (running) {
        }
        System.out.println("m end");
    }

    public static void main(String[] args) {

        new Thread(T::m, "t1").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        T.running = false;
    }
}
