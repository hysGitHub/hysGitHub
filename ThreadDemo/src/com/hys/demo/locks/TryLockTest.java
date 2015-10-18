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
public class TryLockTest {
	private Lock lock = new ReentrantLock();// ReentrantLock，意思是“可重入锁”
	private List<Integer> list = new ArrayList<Integer>();

	public static void main(String[] args) {
		final TryLockTest lt = new TryLockTest();
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
		// 　tryLock()方法是有返回值的，它表示用来尝试获取锁，如果获取成功，则返回true，如果获取失败（即锁已被其他线程获取），则返回false，也就说这个方法无论如何都会立即返回。在拿不到锁时不会一直在那等待。
		//   tryLock(long time, TimeUnit unit)方法和tryLock()方法是类似的，只不过区别在于这个方法在拿不到锁时会等待一定的时间，在时间期限之内如果还拿不到锁，就返回false。如果如果一开始拿到锁或者在等待期间内拿到了锁，则返回true
		if (lock.tryLock()) {
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
		} else {
			System.err.println(h.getName() + "获取锁失败");
		}
	}
}
