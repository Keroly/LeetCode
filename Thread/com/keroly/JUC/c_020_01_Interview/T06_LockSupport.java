/**
 *
 * 面试题：
 * 实现一个容器，提供两个方法，add,size
 * 写两个线程，线程1添加10个元素到容器中，线程2实现监控元素的个数，当个数到五个的时候，线程2给出提示并结束
 *
 */
package com.keroly.JUC.c_020_01_Interview;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

//TODO park unpark

public class T06_LockSupport {

	//添加volatile,使t2能够接到通知 其实是没有用的
	volatile List lists = new ArrayList();

	public void add(Object o) {
		lists.add(o);
	}

	public int size() {
		return lists.size();
	}

	public static void main(String[] args) {
		T06_LockSupport c = new T06_LockSupport();

		CountDownLatch latch = new CountDownLatch(1);

		Thread t2 = new Thread(() -> {
			System.out.println("t2 启动");
			if (c.size() != 5) {

				LockSupport.park();

			}
			System.out.println("t2 结束");


		}, "t2");

		t2.start();

		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}

		new Thread(() -> {
			System.out.println("t1 启动");
			for (int i = 0; i < 10; i++) {
				c.add(new Object());
				System.out.println("add " + i);

				if (c.size() == 5) {
					LockSupport.unpark(t2);
				}

				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

		}, "t1").start();

	}
}
