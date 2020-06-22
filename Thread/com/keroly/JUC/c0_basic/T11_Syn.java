/*

    可重入锁：
        一个同步方法可以调用另一个同步方法，一个线程已经拥有某个对象的锁，再次申请时仍然会得到该对象的锁。
    也就是说：
    synchronized获得的锁是可重入的，如果不这么设计会造成死锁。

 */
package com.keroly.JUC.c0_basic;

public class T11_Syn {

    synchronized void m1() {
        System.out.println("m1 start");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        m2();
        System.out.println("m1 end");
    }

    synchronized void m2() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("m2");

    }

    public static void main(String[] args) {
        T11_Syn t = new T11_Syn();
        t.m1();
    }
}
