
package com.keroly.JUC.c2_volatile;

public class T03_VolatileReference2 {
    private static class Data {
        int a, b;

        public Data(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

    /**
     * volatile 引用类型（包括数组）只能保证引用本身的可见性，不能保证内部字段的可见性
     */
    volatile static Data data;

    public static void main(String[] args) throws InterruptedException {
        Thread writer = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                data = new Data(i, i);
            }
        });

        Thread reader = new Thread(() -> {
            while (data == null) {
            }

            int x = data.a;
            int y = data.b;
            if (x != y) {
                System.out.printf("a = %s, b = %s%n", x, y);
            }
        });

        reader.start();
        writer.start();

        reader.join();
        writer.join();

        System.out.println("end");
    }
}
