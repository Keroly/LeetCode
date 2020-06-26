package com.keroly.JUC.c0_basic;


public class T02_Sleep_Yield_Join {
    public static void main(String[] args) {
        //testSleep();
        testYield();
        //testJoin();
    }

    private static void testJoin() {    // 调用其它线程
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("A" + i);
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                t1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            for (int i = 0; i < 10; i++) {
                System.out.println("B" + i);
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();
    }

    private static void testYield() {    // 优雅让出

        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("A " + i);
                if (i % 10 == 0) {
                    Thread.yield();
                }
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("B " + i);
                if (i % 10 == 0) {
                    Thread.yield();
                }
            }
        }).start();
    }

    private static void testSleep() {
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("Sleep " + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }
}
