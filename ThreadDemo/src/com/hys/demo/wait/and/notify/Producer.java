package com.hys.demo.wait.and.notify;

import java.util.Vector;

/**
 * 生产者
 * 
 * @author hys
 * 
 */
public class Producer implements Runnable {

	private Vector<String> vector;

	Producer(Vector<String> vector) {
		this.vector = vector;
	}

	@Override
	public void run() {

		synchronized (vector) {
			while (true) {
				try {
					if (vector.size() != 0) {
						vector.wait();
					}
					vector.add(new String("apple"));
					System.err.println("生产者 生产了 ");
					vector.notify();
					Thread.sleep(1000);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
