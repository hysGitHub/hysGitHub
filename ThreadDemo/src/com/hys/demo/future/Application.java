package com.hys.demo.future;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class Application {

	public static void main(String[] args) {
		long l = System.currentTimeMillis();
		FutureTask<String> futureTask = new FutureTask<>(new RealData("name"));
		ExecutorService executor = Executors.newFixedThreadPool(1);
		executor.submit(futureTask);
		try {
			Thread.sleep(2000);//模拟主线程的逻辑操作
			System.err.println(futureTask.get());
			long l1 = System.currentTimeMillis();
			System.err.println(l1-l);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}

}
