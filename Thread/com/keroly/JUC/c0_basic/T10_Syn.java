/*

    写方法加锁，读方法不加锁，会有什么问题？  脏读

 */

package com.keroly.JUC.c0_basic;

public class T10_Syn {
    String name;
    double balance;

    public synchronized void set(String name, double balance) {
        this.name = name;
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.balance = balance;
    }

    public /*synchronized*/ double getBalance() {
        return this.balance;
    }

    public static void main(String[] args) {
        T10_Syn t = new T10_Syn();
        new Thread(() -> {t.set("li", 100.0);}).start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println(t.getBalance());

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(t.getBalance());
    }
}
