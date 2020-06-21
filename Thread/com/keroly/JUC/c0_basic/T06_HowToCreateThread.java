package com.keroly.JUC.c0_basic;

public class T06_HowToCreateThread {
    static class MyThread extends Thread {

        @Override
        public void run() {
            System.out.println("MyThread!");
        }
    }

    static class MyRun implements Runnable {

        @Override
        public void run() {
            System.out.println("MyRun");
        }
    }

    public static void main(String[] args) {
        new MyThread().start();
        new Thread(new MyRun()).start();
        new Thread(() -> {
            System.out.println("Lamda!");
        }).start();
    }

}
