/*

    饿汉式
    类加载到内存后，就实例化一个单例，JVM保证线程安全
    简单实用，推荐使用！
    唯一缺点：不管用到与否，类加载时就完成实例化
    Class.forName("")

 */

package com.keroly.JUC.c1_singleton;

public class Mgr01 {
    private static final Mgr01 INSTANCE = new Mgr01();

    private Mgr01() {}; // 谁也别想new一个新的，我自己new好放在上面

    public static Mgr01 getInstance() {return INSTANCE;}

    public void m() {
        System.out.println("m");
    }

    public static void main(String[] args) {
        Mgr01 m1 = Mgr01.getInstance();
        Mgr01 m2 = Mgr01.getInstance();
        System.out.println(m1 == m2);
    }

}
