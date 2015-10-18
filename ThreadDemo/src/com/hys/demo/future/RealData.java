package com.hys.demo.future;

import java.util.concurrent.Callable;

public class RealData implements Callable<String> {
	
	private String data ;
	
	public RealData(String data){
		this.data = data;
	}

	@Override
	public String call() throws Exception {
		try{
			//模拟线程的其他操作,逻辑处理
			Thread.sleep(5000);
		}catch(InterruptedException  e){
			e.printStackTrace();
		}
		return this.data;
	}

}
