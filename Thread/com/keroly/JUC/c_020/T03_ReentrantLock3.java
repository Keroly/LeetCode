
package com.keroly.JUC.c_020;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class T03_ReentrantLock3 {
	Lock lock = new ReentrantLock();

	void m1() {
		try {
			lock.lock();
			for (int i = 0; i < 10; i++) {
				TimeUnit.SECONDS.sleep(1);
				if (i == 1) {
					m2();
				}
				System.out.println(i);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	/*
		可以使用tryLock尝试锁定，不管锁定与否，方法都继续执行
		可以根据tryLock的返回值判断是否锁定
		也可以指定tryLock的事件，由于tryLock(time)抛出异常，所以要注意unlock放在finally中
 	*/

	void m2() {
		
		boolean locked = false;
		
		try {
			locked = lock.tryLock(5, TimeUnit.SECONDS); // 尝试五秒钟之内拿到
			System.out.println("m2 ..." + locked);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			if(locked) lock.unlock();
		}
		
	}

	public static void main(String[] args) {
		T03_ReentrantLock3 rl = new T03_ReentrantLock3();
		new Thread(rl::m1).start();
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		new Thread(rl::m2).start();
	}
}
