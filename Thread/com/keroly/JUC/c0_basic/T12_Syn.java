/*

    程序在执行过程中，如果出现异常，默认情况会被释放

 */
package com.keroly.JUC.c0_basic;

public class T12_Syn {

    int count = 0;

    synchronized void m() {
        System.out.println(Thread.currentThread().getName() + "start");
        while(true) {
            count++;
            System.out.println(Thread.currentThread().getName() + " count = " + count);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (count % 5 == 4) {
                int i = 1 / 0;  // 此处抛出异常，锁释放
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) {
        T12_Syn t = new T12_Syn();

        new Thread(t::m, "t1").start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(t::m, "t2").start();

    }
}

