package com.keroly.JUC.c1_singleton;
/*

    懒汉式
    虽然达到了按需求初始化的目的，但是却带来了线程不安全的问题
    可以通过双重检查解决


 */
public class Mgr03 {
    private /*volatile*/ static Mgr03 INSTANCE;
    // 在超高并发的场景下，使用volatile禁止指令重排序，一般测不出来

    private Mgr03() {};

    public static Mgr03 getInstance() {
        if (INSTANCE == null) {
            // 双重检查
            synchronized (Mgr03.class) {
                if (INSTANCE == null) {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    INSTANCE = new Mgr03();
                }
            }
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
