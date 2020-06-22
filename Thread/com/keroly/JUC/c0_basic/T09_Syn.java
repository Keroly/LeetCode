/*

    同步方法和非同步方法可以同时调用

 */
package com.keroly.JUC.c0_basic;

public class T09_Syn {
    public synchronized void m1(){
        System.out.println(Thread.currentThread().getName() + " m1 start");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " m1 end");
    }

    public void m2(){
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " m2 end");
    }

    public static void main(String[] args) {
        T09_Syn t = new T09_Syn();

        new Thread(t::m1, "t1").start();
        new Thread(t::m2, "t2").start();

    }
}
