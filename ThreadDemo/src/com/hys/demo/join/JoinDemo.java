package com.hys.demo.join;

/**
 * join 主要用于 主线程 等待子线程结束
 * 
 * @author hys
 * 
 */
public class JoinDemo {

	public static void main(String[] args) {
		final Thread h1 = new Thread(new Runnable() {

			@Override
			public void run() {
				
				System.err.println(Thread.currentThread().getName()+"执行");
			}
		});
		final Thread h2 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					h1.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.err.println(Thread.currentThread().getName()+"执行");
			}
		});
		final Thread h3 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					h2.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.err.println(Thread.currentThread().getName()+"执行");
			}
		});
		try {
			h3.start();
			h2.start();
			h1.start();
			//主线程 等待 h3 执行完毕
			h3.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.err.println(Thread.currentThread().getName()+"执行");
	}
}
