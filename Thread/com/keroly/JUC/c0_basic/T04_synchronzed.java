
package com.keroly.JUC.c0_basic;


public class T04_synchronzed {

    public synchronized void syncMethod1() {
        System.out.println("syncMethod1");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void syncMethod2() {
        System.out.println("syncMethod2");
    }

    public void normalMethod() {
        System.out.println("normal");
    }

    public static void main(String[] args) throws InterruptedException {
        T04_synchronzed t = new T04_synchronzed();
        Thread threadA = new Thread(t::syncMethod1);
        Thread threadB = new Thread(t::syncMethod2);
        Thread threadC = new Thread(t::normalMethod);

        threadA.start();
        threadB.start();
        threadC.start();

        threadA.join();
        threadB.join();
        threadC.join();

    }

}
