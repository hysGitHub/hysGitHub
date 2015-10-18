package com.hys.demo.wait.and.notify;

import java.util.Vector;
/**
 * 消费者
 * @author hys
 *
 */
public class Consumer implements Runnable {

	private Vector<String> vector ;
	public Consumer(Vector<String> vector){
		this.vector = vector;
	}
	@Override
	public void run() {

		synchronized (vector) {
			while(true){
				try{
					if(vector.size() == 0)
						vector.wait();
					System.err.println("消费者 准备消费 。。。"+vector.size());
					vector.clear();
					vector.notify();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}
	}

}
