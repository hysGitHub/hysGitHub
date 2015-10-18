package com.hys.demo.locks;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/**
 * 
 * lock 和 synchronized 区别
 *
 */
public class LockTest {
	private Lock lock = new ReentrantLock();//ReentrantLock，意思是“可重入锁”
	private List<Integer> list = new ArrayList<Integer>();

	public static void main(String[] args) {
		final LockTest lt = new LockTest();
		new Thread(new Runnable() {

			@Override
			public void run() {
				lt.insert(Thread.currentThread());
			}
		}).start();
		new Thread(new Runnable() {

			@Override
			public void run() {
				lt.insert(Thread.currentThread());
			}
		}).start();
	}

	public void insert(Thread h) {
		lock.lock();
		try {
			System.err.println(h.getName() + "获得了锁");
			for (int i = 0; i < 5; i++) {
				list.add(i);
			}
		} catch (Exception e) {

		} finally {
			System.err.println(h.getName() + "释放了锁");
			lock.unlock();
		}
	}
}
