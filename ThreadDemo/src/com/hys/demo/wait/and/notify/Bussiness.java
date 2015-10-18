package com.hys.demo.wait.and.notify;

public class Bussiness {

	private boolean sonFlag = true;
	public void sonThread(int i) {
		synchronized (this) {
			while(!sonFlag){
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			for (int j = 0; j < 20; j++) {
				System.err.println(Thread.currentThread().getName() + "正在 运行"
						+ i + "行" + j + "列");
			}
			System.err.println(Thread.currentThread().getName() + "第" + i
					+ "次 循环");
			sonFlag = false;
			notify();
		}
	}

	public void mainThread(int i) {
		synchronized (this) {
			while(sonFlag){
				try {
					//当前线程 等待
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			for (int j = 0; j < 50; j++) {
				System.out.println(Thread.currentThread().getName() + "正在 运行"
						+ i + "行" + j + "列");
			}
			System.out.println(Thread.currentThread().getName() + "第" + i
					+ "次 循环");
			sonFlag = true;
			notify();//通知 其他线程 争抢所
		}
	}
}
