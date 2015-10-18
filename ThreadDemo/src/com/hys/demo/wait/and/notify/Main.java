package com.hys.demo.wait.and.notify;

import java.util.Vector;

public class Main {

	public static void main(String[] args) {
		Vector<String> vector = new Vector<String>();
		Thread h2 = new Thread(new Consumer(vector));
		h2.start();

		Thread h = new Thread(new Producer(vector));
		h.start();
	}
}
