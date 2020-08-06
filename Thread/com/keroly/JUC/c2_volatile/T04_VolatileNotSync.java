package com.keroly.JUC.c2_volatile;

/*

    volatile只保证线程间可见性，不保证同步，也就是volatile不能替代synchronized

 */

import java.util.ArrayList;
import java.util.List;

public class T04_VolatileNotSync {

    volatile int count = 0;

    /*synchronized*/ void m() {
        for (int i = 0; i < 10000; i++) {
            count++;
        }
    }

    public static void main(String[] args) {
        T04_VolatileNotSync t = new T04_VolatileNotSync();

        List<Thread> threads = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            threads.add(new Thread(t::m, "thread-" + i));
        }

        threads.forEach((o) -> o.start());
        threads.forEach((o) -> {
            try {
                o.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        System.out.println(t.count);
    }
}
