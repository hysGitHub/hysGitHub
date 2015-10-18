package com.hys.demo.locks;

public class MyThread extends Thread {

	private LocInterruptiblyTest interruptiblyTest ;
	public MyThread(LocInterruptiblyTest interruptiblyTest){
		this.interruptiblyTest = interruptiblyTest;
	}
	@Override
	public void run() {
		try {
			interruptiblyTest.insert(Thread.currentThread());
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName()+"被中断");
        }
	};
}
