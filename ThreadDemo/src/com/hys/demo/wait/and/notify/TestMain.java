package com.hys.demo.wait.and.notify;

public class TestMain {

	public static void main(String[] args) {
		final Bussiness bussiness = new Bussiness();
		new Thread(new Runnable() {
			@Override
			public void run() {
				//子线程 循环 五十次
				for(int i = 0;i<10;i++){
					bussiness.sonThread(i);
				}
			}
		}).start();
		//主线程 循环 五十次
		for(int i = 0;i<10;i++){
			bussiness.mainThread(i);
		}
	}
}
