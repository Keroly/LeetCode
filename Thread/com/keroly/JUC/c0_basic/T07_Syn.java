/*

    锁的不同方式

 */
package com.keroly.JUC.c0_basic;

public class T07_Syn {

    private int count = 10;
    static private int count_1 = 10;
    Object o = new Object();

    public void method() {
        synchronized (o) {
            count--;
            System.out.println(Thread.currentThread().getName() + " count = " + count);
        }
    }



    public void method_1() {
        synchronized (this) {
            count--;
            System.out.println(Thread.currentThread().getName() + " count = " + count);
        }
    }

    public synchronized void method_2() {   // 等同于synchronized (this)
            count--;
            System.out.println(Thread.currentThread().getName() + " count = " + count);
    }



    public static void method_3() {
        synchronized (T07_Syn.class){
            count_1--;
            System.out.println(Thread.currentThread().getName() + " count = " + count_1);
        }
    }

    public synchronized static void method_4() {   // 等同于synchronized (T07_Syn.class)
        count_1--;
        System.out.println(Thread.currentThread().getName() + " count = " + count_1);
    }
}
