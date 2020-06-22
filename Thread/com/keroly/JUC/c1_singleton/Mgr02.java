package com.keroly.JUC.c1_singleton;

/*

    懒汉式
    虽然达到了按需求初始化的目的，但是却带来了线程不安全的问题
    可以通过synchronized解决，但也带来效率下降


 */

public class Mgr02 {
    private static Mgr02 INSTANCE;

    private Mgr02() {};

    public /*synchronized*/ static Mgr02 getInstance() {
        if (INSTANCE == null) { // 这里线程不安全
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            INSTANCE = new Mgr02();
        }
        return INSTANCE;
    }

    public void m() {
        System.out.println("m");
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(Mgr03.getInstance().hashCode());
            }).start();
        }
    }
}
